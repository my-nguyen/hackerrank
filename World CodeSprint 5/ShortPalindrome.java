import java.util.*;

class ShortPalindrome {
    static class Palindrome {
        List<String> singles;
        List<String> mixes;

        public Palindrome(String input) {

        }
    }
    // correct solution but takes too long (time complexity O(n^4))
    static long countTuples2(String string) {
        long count = 0;
        for (int i = 0; i < string.length()-3; i++) {
            char one = string.charAt(i);
            for (int j = i+3; j < string.length(); j++) {
                if (string.charAt(j) == one) {
                    // System.out.println("match (" + one + "), left at " + i + ", right at " + j);
                    for (int k = i+1; k < j-1; k++) {
                        char two = string.charAt(k);
                        for (int l = k+1; l < j; l++) {
                            if (string.charAt(l) == two) {
                                // System.out.println("\tmatch (" + two + "), left at " + k + ", right at " + l);
                                count++;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    // a supposedly improved version that uses a hash table but still times out
    static long countTuples(String string) {
        // store the index of each character in a hash table
        Map<Character, List<Integer>> hash = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char key = string.charAt(i);
            List<Integer> indices = hash.get(key);
            if (indices == null) {
                indices = new ArrayList<>();
                hash.put(key, indices);
            }
            indices.add(i);
        }
        /*
        for (Map.Entry<Character, List<Integer>> entry : hash.entrySet()) {
            System.out.print("key: " + entry.getKey() + ", value: ");
            for (int i : entry.getValue())
                System.out.print(i + " ");
            System.out.println();
        }
        */

        long count = 0;
        for (int i = 0; i < string.length()-3; i++) {
            char one = string.charAt(i);
            List<Integer> oneIndices = hash.get(one);
            for (int j : oneIndices) {
                if (j <= i+2)
                    continue;
                // System.out.println("match (" + one + "), left at " + i + ", right at " + j);
                for (int k = i+1; k < j-1; k++) {
                    char two = string.charAt(k);
                    List<Integer> twoIndices = hash.get(two);
                    for (int l : twoIndices) {
                        if (l <= k)
                            continue;
                        if (l >= j)
                            break;
                        else {
                            // System.out.println("\tmatch (" + two + "), left at " + k + ", right at " + l);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        long count = countTuples2(string);
        System.out.println(count);
    }
}
