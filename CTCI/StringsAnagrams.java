import java.util.*;

class StringsMakingAnagrams {
    static final int ALPHABET_COUNT = 26;

    // this method counts the occurrence frequency of each letter in string
    // and returns the counts as an int[]
    static int[] countFrequencies(String string) {
        // keep count of each of the 26 letters in the English alphabet
        int[] counts = new int[ALPHABET_COUNT];
        // initialize all counts to 0
        for (int i = 0; i < ALPHABET_COUNT; i++)
            counts[i] = 0;

        int letterA = Character.getNumericValue('a');
        for (char letter : string.toCharArray()) {
            // get the numeric value of the letter, i.e. the numeric value for
            // 'a' is 0, for 'b' is 1, etc.
            int value = Character.getNumericValue(letter) - letterA;
            // this numeric value is the index to the count array, which keeps
            // count of the occurrence frequency of the letter
            counts[value] += 1;
        }

        return counts;
    }

    static int numberNeeded(String first, String second) {
        int[] hashFirst = countFrequencies(first);
        int[] hashSecond = countFrequencies(second);

        int count = 0;
        for (int i = 0; i < ALPHABET_COUNT; i++) {
            // if letter is in first string but not in second string, then
            // count the occurrence frequency of the letter in the first string
            if (hashFirst[i] != 0 && hashSecond[i] == 0)
                count += hashFirst[i];
            // vice versa for the second string
            else if (hashFirst[i] == 0 && hashSecond[i] != 0)
                count += hashSecond[i];
            // if if letter is in both first string and second string, then
            // count the extra occurrences
            else if (hashFirst[i] != 0 && hashSecond[i] != 0)
                count += Math.abs(hashFirst[i] - hashSecond[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
