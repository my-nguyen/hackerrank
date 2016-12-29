import java.util.*;

public class Solution {
    static int minDistance(int[] array) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> list = indices.get(array[i]);
            if (list == null) {
                list = new ArrayList<>();
                indices.put(array[i], list);
            }
            list.add(i);
            // System.out.println("adding index " + i + " for value " + array[i]);
        }

        int min = array.length;
        for (int i = 0; i < array.length; i++) {
            List<Integer> list = indices.get(array[i]);
            if (list.size() > 1) {
                for (int j = 0; j < list.size()-1; j++) {
                    min = Math.min(min, Math.abs(list.get(j) - list.get(j+1)));
                    // System.out.println("value: " + array[i] + ", indices: " + list.get(j) + ", " + list.get(j+1) + ", min: " + min);
                }
            }
        }

        return min == array.length ? -1 : min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
        }
        System.out.println(minDistance(A));
    }
}
