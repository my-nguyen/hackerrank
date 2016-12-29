import java.util.*;
import java.math.*;

class MatrixTracing {
    static final int DIVISOR = 1000000007;
    static final int MAX_WIDTH = 9999;
    static int[][] count = new int[MAX_WIDTH][MAX_WIDTH];
    static boolean counted = false;

    // precalculate all numbers in a 9999x9999 matrix. this requires both the
    // length and width of matrix to be under 9999
    // this approach passes test cases 0, 1, 2, 3, 4, 5, 9, 10
    // and timeouts on cases 6, 7, 8
    static void precalculate() {
        if (!counted) {
            counted = true;
            for (int j = 0; j < MAX_WIDTH; j++) {
                // Count of paths to reach any cell in first column is 1
                count[0][j] = 1;
                // Count of paths to reach any cell in second column is j+1
                count[1][j] = j + 1;
            }

            // Calculate count of paths for other cells in a bottom-up manner
            // recursively
            for (int i = 2; i < MAX_WIDTH; i++) {
                count[i][0] = 1;
                for (int j = 1; j < MAX_WIDTH; j++) {
                    count[i][j] = (count[i][j-1] + count[i-1][j]) % DIVISOR;
                }
            }
        }
    }

    static int calculate1(int m, int n) {
        precalculate();
        return count[m-1][n-1];
    }

    // this reduces the required space when one dimension is too large
    // this approach passes test cases 0, 1, 2, 9, 10
    // and fails cases 2, 3, 4, 5, 6, 7, 8
    static int calculate2(int m, int n) {
        int[][] compte = new int[2][n];
        for (int j = 0; j < n; j++) {
            // Count of paths to reach any cell in first column is 1
            compte[0][j] = 1;
            // Count of paths to reach any cell in second column is j+1
            compte[1][j] = j + 1;
        }

        // Calculate count of paths for other cells in bottom-up manner using
        // the recursive solution
        for (int i = 2; i < m; i++) {
            compte[i%2][0] = 1;
            for (int j = 1; j < n; j++) {
                compte[i%2][j] = (compte[i%2][j-1] + compte[(i-1)%2][j]) % DIVISOR;
            }
        }
        int row = (m-1) % 2;
        int column = n - 1;
        int result = compte[row][column];
        return result;
    }

    // this calculates recursively
    // this approach passes test cases 0, 9, 10
    // and fails cases 1, 2, 3, 4, 5, 6, 7, 8
    // this approach takes too long
    static int calculate3(int m, int n) {
        if (m == 1 || n == 1)
            return 1;

        return (calculate3(m-1, n) + calculate3(m, n-1)) % DIVISOR;
    }

    static BigInteger factorial(int lower, int upper) {
        BigInteger result = BigInteger.ONE;
        for (int i = lower; i <= upper; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    // this uses Pascal's triangle
    // this approach passes test cases 0, 1, 9, 10
    // and fails cases 2, 3, 4, 5, 6, 7, 8
    // this approach takes too long
    static int calculate4(int m, int n) {
        // calculate Pascal row and column
        int row = (m-1) + (n-1);
        int column = Math.min(m, n) - 1;
        // binomial coefficient at (row, column)
        // binomial = factorial(row) / (factorial(row-column) * factorial(column))
        int diff = row - column;
        int max = Math.max(diff, column);
        int min = Math.min(diff, column);
        // System.out.println("m: " + m + ", n: " + n + ", row: " + row + ", column: " + column);
        BigInteger numerator = factorial(max+1, row);
        // System.out.println("numerator: " + numerator);
        BigInteger denominator = factorial(1, min);
        // System.out.println("denominator: " + denominator);
        BigInteger result = numerator.divide(denominator);
        result = result.mod(BigInteger.valueOf(DIVISOR));
        // System.out.println("result: " + result);
        return result.intValue();
    }

    static int numberOfPaths(int m, int n)
    {
        return calculate4(m, n);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            int paths = numberOfPaths(rows, columns);
            System.out.println(paths);
        }
    }
}
