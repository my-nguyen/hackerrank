import java.util.*;

class MinimizeSummation {
    static long summation(int[] array, int length) {
        long minDiff = 0;
        for (int i = 0; i < array.length-length+1; i++) {
            long sum = 0;
            for (int j = 0; j < length-1; j++) {
                // System.out.println("j: " + j);
                for (int k = j+1; k < length; k++) {
                    // System.out.println("i: " + i + ", j: " + j + ", k: " + k);
                    long diff = array[i+j] - array[i+k];
                    // System.out.println("left: " + array[i+j] + ", right: " + array[i+k] + ", diff: " + diff);
                    long square = 2 * diff * diff;
                    sum += square;
                    // System.out.println("2square: " + square + ", sum: " + sum);
                }
            }
            if (minDiff == 0)
                minDiff = sum;
            else
                minDiff = Math.min(minDiff, sum);
            // System.out.println("minDiff: " + minDiff);
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(summation(a, k));
    }
}
