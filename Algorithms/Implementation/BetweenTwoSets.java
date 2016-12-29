// non-working solution
import java.util.*;

public class Solution {
    static long gcd(long one, long two) {
        while (one != 0) {
            long tmp = one;
            one = two % one;
            two = tmp;
        }
        return two;
    }

    static long gcd(long[] array) {
        long gcd;
        if (array.length == 1)
            gcd = array[0];
        else {
            gcd = gcd(array[0], array[1]);
            for (int i = 2; i < array.length; i++) {
                gcd = gcd(array[i], gcd);
            }
        }
        return gcd;
    }

    static long lcm(long one, long two) {
        return (one * two) / gcd(one, two);
    }

    // this method returns the least common multiple of an array of more than 2 integers
    static long lcm(long[] array) {
        long lcm;
        if (array.length == 1)
            lcm = array[0];
        else {
            lcm = lcm(array[0], array[1]);
            for (int i = 2; i < array.length; i++) {
                lcm = lcm(array[i], lcm);
            }
        }
        return lcm;
    }

    static int countFactors(long small, long large) {
        // System.out.println("small: " + small + ", large: " + large);
        int count = 0;
        for (long i = small; i <= large; i++) {
            if (large % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] a = new long[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextLong();
        }
        long[] b = new long[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextLong();
        }
        long lcm = lcm(a);
        long gcd = gcd(b);
        System.out.println(countFactors(lcm, gcd));
    }
}
