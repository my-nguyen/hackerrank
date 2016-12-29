import java.util.*;

class DFSConnectedCell {
    private static int cell(int[][] matrix, int row, int column, boolean[][] visited) {
        if (row < 0 || row >= matrix.length)
            return 0;
        if (column < 0 || column >= matrix[row].length)
            return 0;
        if (matrix[row][column] == 0)
            return 0;
        if (visited[row][column])
            return 0;
        visited[row][column] = true;
        /*
        return cell(matrix, row-1, column-1, visited) +
            cell(matrix, row-1, column, visited) +
            cell(matrix, row-1, column+1, visited)
            */
        int sum = 1;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = column-1; j <= column+1; j++) {
                if (i != row && j != column) {
                    int count = cell(matrix, i, j, visited);
                    System.out.println("\ti: " + i + ", j: " + j + ", count: " + count);
                    sum += count;
                }
            }
        }
        return sum;
    }

    // my solution which doesn't work yet
    public static int getBiggestRegion2(int[][] matrix) {
        int maxRegion = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("checking at " + i + ", " + j);
                int region = cell(matrix, i, j, visited);
                maxRegion = Math.max(maxRegion, region);
            }
        }
        return maxRegion;
    }

    // solution copied from goodengineer in Discussions
    public static int getBiggestRegion(int[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, countCells(matrix, i, j));
            }
        }
        return max;
    }

    private static int countCells(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
            return 0;
        if (matrix[i][j] == 0)
            return 0;

        int count = matrix[i][j]--;
        count += countCells(matrix, i + 1, j);
        count += countCells(matrix, i - 1, j);
        count += countCells(matrix, i, j + 1);
        count += countCells(matrix, i, j - 1);
        count += countCells(matrix, i + 1, j + 1);
        count += countCells(matrix, i - 1, j - 1);
        count += countCells(matrix, i - 1, j + 1);
        count += countCells(matrix, i + 1, j - 1);
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
