// solution fails with the following input
// 10 5
// 770528134 663501748 384261537 800309024 103668401 538539662 385488901 101262949 557792122 46058493
// expected output
// 6
import java.util.*;

public class NonDivisibleSubset {
    static String toString(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int value : list) {
            builder.append(value + " ");
        }
        return builder.toString();
    }

    static int countNonDivisibles(int[] array, int divisor) {
        Map<Integer, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < array.length-1; i++) {
            // list of all numbers that when combined with the current
            // element array[i], are not divisible by divisor
            List<Integer> list = new ArrayList<>();
            hash.put(array[i], list);
            for (int j = i+1; j < array.length; j++) {
                if ((array[i] + array[j]) % divisor != 0) {
                    list.add(array[j]);
                }
            }
            // System.out.println("list at " + array[i] + ": " + list);
        }

        int max = 0;
        // go thru the map to revise each list by removing those numbers that
        // when combined with another within the list are divisible by divisor
        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
            int key = entry.getKey();
            List<Integer> existingList = entry.getValue();
            List<Integer> revisedList = new ArrayList<>();
            // first entry in the revised list
            revisedList.add(key);
            // System.out.println(key + " added to revised list at " + key);
            if (existingList.size() == 0)
                continue;
            // second entry in the revised list
            revisedList.add(existingList.get(0));
            // System.out.println(existingList.get(0) + " added to revised list at " + key);
            // System.out.println("existing list: " + existingList);
            for (int i = 1; i < existingList.size(); i++) {
                int applicant = existingList.get(i);
                // System.out.println("applicant at " + i + ": " + applicant);
                boolean approved = true;
                for (int j = 0; j < i; j++) {
                    int member = existingList.get(j);
                    // whether the next number, when combined with the current
                    // one in the existing list, is divisible by divisor
                    if (!hash.get(member).contains(applicant)) {
                        // System.out.println(member + " doesn't contain " + applicant + ": rejected");
                        approved = false;
                        break;
                    }
                }
                // only add to existing list if the next number, when combined
                // with all existing numbers in list, is not divisible by divisor
                if (approved) {
                    // System.out.println(applicant + " added to membership");
                    revisedList.add(applicant);
                }
            }
            // hash.put(key, revisedList);
            // System.out.println("list at " + key + " replaced");
            // System.out.println("revised list: " + revisedList);
            max = Math.max(max, revisedList.size());
            // System.out.println("max: " + max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int divisor = in.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++)
            array[i] = in.nextInt();

        System.out.println(countNonDivisibles(array, divisor));
    }
}
