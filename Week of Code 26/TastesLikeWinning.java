import java.util.*;

class TastesLikeWinning {
    static long factorial(int n) {
        long product = 1;
        for (int i = 2; i <= n; i++)
            product *= i;
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int piles = in.nextInt();
        int power = in.nextInt();
        int stones = (int)Math.pow(2, power) - 1;
        long games = factorial(stones) / factorial(stones-piles);
        games %= 1000000007;
        System.out.println(games);
    }
}
