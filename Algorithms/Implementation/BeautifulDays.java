import java.util.*;

public class Solution {
    private static int reverse(int number) {
        int result = 0;
        while (number > 0) {
            int remainder = number % 10;
            result = result*10 + remainder;
            number /= 10;
        }
        return result;
    }

    static int countBeautifuls(int low, int high, int divisor) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            int diff = Math.abs(i - reverse(i));
            if (diff % divisor == 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int low = in.nextInt();
        int high = in.nextInt();
        int divisor = in.nextInt();

        System.out.println(countBeautifuls(low, high, divisor));
    }
}
