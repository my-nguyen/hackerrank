import java.util.*;

public class BiggerIsGreater {
    static class Pair {
        int low;
        int high;

        public Pair(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public String toString() {
            return low + " " + high;
        }
    }

    static Pair findPair(String input) {
        // the upper bound starts from the end of the input string
        for (int i = input.length()-1; i > 0; i--) {
            // find the lower bound
            for (int j = i-1; j >= 0; j--) {
                // within the range of (lower bound, upper bound)
                for (int k = i; k > j; k--) {
                    // find 2 characters that should be swapped
                    if (input.charAt(j) < input.charAt(k)) {
                        return new Pair(j, k);
                    }
                }
            }
        }
        // found nothing at this point
        return null;
    }

    static String lexico(String input) {
        Pair pair = findPair(input);
        if (pair == null)
            return "no answer";
        else {
            StringBuilder builder = new StringBuilder();
            // collect all characters from the beginning of the input string
            // until the lower bound of the pair returned by findPair()
            builder.append(input.substring(0, pair.low));
            // replace the character at the lower bound with that at the upper
            // bound
            builder.append(input.charAt(pair.high));
            List<Character> list = new ArrayList<>();
            // collect all characters except for that at the upper bound
            for (int i = pair.low; i < input.length(); i++) {
                if (i != pair.high) {
                    list.add(input.charAt(i));
                }
            }
            // sort these characters
            Collections.sort(list);
            // append all these characters in the StringBuilder
            for (char letter : list) {
                builder.append(letter);
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.next());
        String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = in.next();
            System.out.println(lexico(strings[i]));
        }
    }
}
