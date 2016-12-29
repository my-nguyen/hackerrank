import java.util.*;

public class Solution {
    static long counter(long number) {
        long key = 3;
        long value = 3;
        while (key < number) {
            value *= 2;
            key += value;
        }
        // the magic formula to produce the desired counter
        return key - number + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long t = in.nextLong();
        System.out.println(counter(t));
    }
}
