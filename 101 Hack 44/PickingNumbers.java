import java.util.*;

public class PickingNumbers {
    static int maxIntegers(int[] array) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = counts.get(array[i]);
            // System.out.println("i: " + i + ", array[i]: " + array[i] + ", count: " + count);
            if (count == null)
                counts.put(array[i], 1);
            else
                counts.put(array[i], count+1);
        }
        Iterator it = counts.entrySet().iterator();
        Map.Entry<Integer, Integer> previous = (Map.Entry<Integer, Integer>)it.next();
        int max = previous.getValue();
        // System.out.println("first <" + previous.getKey() + ", " + previous.getValue() + ">");
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> next = (Map.Entry<Integer, Integer>)it.next();
            // System.out.println("next: <" + next.getKey() + ", " + next.getValue() + ">");
            if (next.getKey() - previous.getKey() == 1) {
                max = Math.max(max, next.getValue()+previous.getValue());
                // System.out.println("previous: " + (int)previous.getKey() + ", next: " + (int)next.getKey() + ", max: " + max);
            } else {
                max = Math.max(max, next.getValue());
            }
            previous = next;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(maxIntegers(a));
    }
}
