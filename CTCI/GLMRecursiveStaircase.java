class GLMRecursiveStaircase {
    // first try: time complexity O(3^n): very inefficient
    public static int countPathsRecursive(int steps) {
        if (steps < 0)
            return 0;
        if (steps == 0)
            return 1;

        return countPathsRecursive(steps-1) + countPathsRecursive(steps-2) + countPathsRecursive(steps-3);
    }

    // second try: time complexity O(n) but space complexity is O(n)
    public static int countPathsMemo(int steps, int[] memo) {
        if (steps < 0)
            return 0;
        if (steps == 0)
            return 1;

        if (memo[steps] == 0) {
            memo[steps] = countPathsMemo(steps-1, memo) + countPathsMemo(steps-2, memo) + countPathsMemo(steps-3, memo);
        }
        return memo[steps];
    }

    public static int countPathsMemo(int steps) {
        return countPathsMemo(steps, new int[steps+1]);
    }

    // third try: no O(n) of call stack space, but still O(n) for paths
    public static int countPathsDynamic(int steps) {
        if (steps < 0)
            return 0;
        if (steps <= 1)
            return 1;

        int[] paths = new int[steps+1];
        paths[0] = 0;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= steps; i++) {
            paths[i] = paths[i-1] + paths[i-2] + paths[i-3];
        }
        return paths[steps];
    }

    // fourth and final try: space complexity only O(1)
    public static int countPathsIterative(int steps) {
        if (steps < 0)
            return 0;
        if (steps <= 1)
            return 1;

        int[] paths = { 1, 1, 2 };
        for (int i = 3; i <= steps; i++) {
            int sum = paths[2] + paths[1] + paths[0];
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = sum;
        }
        return paths[2];
    }
}
