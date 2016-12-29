import java.util.*;

public class MinMaxSum {
    static class Pair {
        long min;
        long max;

        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    static Pair minMaxSums(long[] array) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            long sum = 0;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    sum += array[j];
                }
            }
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            // System.out.println("i: " + i + ", sum: " + sum + ", min: " + min + ", max: " + max);
        }
        return new Pair(min, max);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] array = new long[5];
        for (int i = 0; i < array.length; i++)
            array[i] = in.nextLong();

        Pair pair = minMaxSums(array);
        System.out.println(pair.min + " " + pair.max);
    }
}
