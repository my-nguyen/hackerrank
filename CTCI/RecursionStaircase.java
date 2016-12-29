import java.util.*;

public class RecursionStaircase {
    static int climb(int height, int[] memo) {
        if (height == 0 || height == 1)
            return 1;
        if (height == 2)
            return 2;
        if (memo[height] == 0)
            memo[height] = climb(height-1, memo) + climb(height-2, memo) + climb(height-3, memo);
        return memo[height];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            int[] memoization = new int[n+1];
            System.out.println(climb(n, memoization));
        }
    }
}
