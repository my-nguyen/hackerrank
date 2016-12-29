import java.util.*;

class MergeSortInversions {
    // still a work in progress, since this times out on several test cases
    static long countInversions(int[] array) {
        long count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i-1]) {
                int current = 0;
                for (int j = i-1; j >= 0 && array[j] > array[i]; j--)
                    current++;

                // System.out.println("shifting " + current + " elements from position " + (i-current));
                count += current;

                int tmp = array[i];
                for (int j = 0; j < current; j++) {
                    array[i-j] = array[i-j-1];
                }
                array[i-current] = tmp;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int setCount = in.nextInt();
        // System.out.println(setCount + " data sets");
        for (int i = 0; i < setCount; i++) {
            int elementCount = in.nextInt();
            // System.out.println(elementCount + " elements");
            int[] elements = new int[elementCount];
            for (int j = 0; j < elementCount; j++) {
                elements[j] = in.nextInt();
                // System.out.print(elements[j] + " ");
            }
            // System.out.println();

            System.out.println(countInversions(elements));
        }
    }
}
