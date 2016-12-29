import java.util.*;

public class Solution {
    static int maxFrequency(List<Integer> list) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            Integer value = frequencies.get(key);
            value = value == null ? 1 : (value+1);
            frequencies.put(key, value);
        }

        int max = 0;
        for (int frequency : frequencies.values()) {
            max = Math.max(max, frequency);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++)
            list.add(in.nextInt());

        int max = maxFrequency(list);
        System.out.println(list.size() - max);
    }
}
