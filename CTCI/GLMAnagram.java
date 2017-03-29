// Two strings are anagrams if they both contain the same letters with same count, but with different order
class GLMAnagram {
    public static int NUMBER_LETTERS = 26;

    // compare the two arrays int[26]; at each letter, count the difference
    // the sum of all the differences is the result, which is the number of letters
    // to remove from one string to make it an analgram of another string.
    public static int getDelta(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return -1;
        int delta = 0;
        for (int i = 0; i < array1.length; i++) {
            int difference = Math.abs(array1[i] - array2[i]);
            delta += difference;
        }
        return delta;
    }

    // count the number of occurrences of each letter in string
    public static int[] getCharCounts(String s) {
        // use int[26] to represent the 26 letters in the alphabet
        // initially all elements in the int[26] are initialized to 0
        // then the for loop will increment the count for the corresponding letter
        int[] charCounts = new int[NUMBER_LETTERS];
        for (int i = 0; i < s.length; i++) {
            char c = s.charAt(i);
            int offset = (int)'a';
            int code = c - offset;
            charCounts[code]++;
        }
        return charCounts;
    }

    public static int numberNeeded(String first, String second) {
        int[] charCount1 = getCharCounts(first);
        int[] charCount2 = getCharCounts(second);
        return getDelta(charCount1, charCount2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        System.out.println(numberNeeded(first, second));
    }
}
