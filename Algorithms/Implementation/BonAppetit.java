import java.util.*;

public class Solution {
    static String calculate(int[] prices, int skip, int charge) {
        int total = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i != skip)
                total += prices[i];
        }
        if (total/2 == charge)
            return "Bon Appetit";
        else
            return Integer.toString(charge - total/2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();
        int skip = in.nextInt();
        int[] prices = new int[total];
        for (int i = 0; i < total; i++)
            prices[i] = in.nextInt();
        int charge = in.nextInt();

        System.out.println(calculate(prices, skip, charge));
    }
}
