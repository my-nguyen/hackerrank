import java.util.*;

class Test2 {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 5; i++)
            map.put(i, i*i);

        int value4 = map.get(4);
        System.out.println("value4: " + value4);
        int value7 = map.get(7);
        System.out.println("value7: " + value7);
    }
}
