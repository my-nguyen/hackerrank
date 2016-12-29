import java.util.*;

public class Solution {
    static class Range {
        int low;
        int high;

        Range(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public String toString() {
            return low + ", " + high;
        }
    }

    static void reverse(int[] array, int begin, int end) {
        while (begin < end) {
            swap(array, begin, end);
            begin++;
            end--;
        }
    }

    static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1])
                return false;
        }
        return true;
    }

    static Range findSwap(int[] array) {
        int begin = 0;
        // find index to the first element out of ascending order
        while (begin < array.length-1 && array[begin] < array[begin+1])
            begin++;
        int end = begin + 1;
        // find index to swap, which is either the one right after the begin index
        // OR the second element out of ascending order
        while (end < array.length-1 && array[end] < array[end+1])
            end++;
        if (end == array.length-1)
            end = begin + 1;
        else
            end++;

        return new Range(begin, end);
    }

    static Range findReverse(int[] array) {
        int begin = 0;
        while (begin < array.length-1 && array[begin] < array[begin+1])
            begin++;
        int end = begin + 1;
        while (end < array.length-1 && array[end] > array[end+1])
            end++;
        if (end == array.length-1)
            return null;
        return new Range(begin, end);
    }

    static String sort(int[] array) {
        if (isSorted(array))
            return "yes";
        // not sorted means there is at least 2 elements in array
        Range range = findSwap(array);
        if (range != null) {
            int[] copy = Arrays.copyOf(array, array.length);
            swap(copy, range.low, range.high);
            if (isSorted(copy)) {
                return "yes\nswap " + (range.low+1) + " " + (range.high+1);
            }
        }
        range = findReverse(array);
        if (range != null) {
            reverse(array, range.low, range.high);
            if (isSorted(array)) {
                return "yes\nreverse " + (range.low+1) + " " + (range.high+1);
            }
        }
        return "no";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.nextInt();
        System.out.println(sort(array));
    }
}
