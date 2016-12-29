import java.util.*;

public class BeautifulTriplets {
    static int countTriplets(int[] array, int diff) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            hash.put(array[i], i);
        }
        int count = 0;
        for (int i = 0; i < array.length-2; i++) {
            int one = array[i];
            int two = one + diff;
            int three = two + diff;
            if (hash.get(two) != null && hash.get(three) != null) {
                // System.out.println(i + ", " + hash.get(two) + ", " + hash.get(three));
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int diff = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.nextInt();
        System.out.println(countTriplets(array, diff));
    }
}
