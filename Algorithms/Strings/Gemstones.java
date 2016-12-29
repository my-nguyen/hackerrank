import java.util.*;

public class Solution {
    static int countGems(List<String> rocks) {
        Map<Character, Integer> counts = new HashMap<>();
        // for each rock in the list
        for (String rock : rocks) {
            // collect all distinct elements within this rock
            Set<Character> elements = new HashSet<>();
            for (char element : rock.toCharArray()) {
                elements.add(element);
            }

            // keep count of the distinct elements in a map
            for (Character element : elements) {
                Integer count = counts.get(element);
                if (count == null)
                    counts.put(element, 1);
                else
                    counts.put(element, count+1);
            }
        }
        
        // count all the elements that have occurred in every single rock
        int count = 0;
        for (Integer value : counts.values()) {
            if (value == rocks.size())
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        List<String> rocks = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            rocks.add(in.nextLine());
        }
        System.out.println(countGems(rocks));
    }
}
