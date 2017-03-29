class GLMMemoization {
    int fib(int n, int[] memo) {
        if (n == 0 || n == 1)
            return n;
        if (memo[n] == 0) {
            memo[n] = fib(n-1) + fib(n-2);
        }
        return memo[n];
    }

    int countPaths(boolean[] grid, int row, int col, int[][] paths) {
        if (!validSquare(grid, row, col))
            return 0;
        if (isAtEnd(grid, row, col))
            return 1;
        if (paths[row][col] == 0) {
            paths[row][col] = countPaths(grid, row+1, col) + countPaths(grid, row, col+1);
        }
        return paths[row][col];
    }
}
