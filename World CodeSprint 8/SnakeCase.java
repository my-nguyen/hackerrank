import java.util.*;

public class Solution {
    static int countWords(String phrase) {
        int count = 1;
        int begin = 0;
        int index = 0;
        while ((index = phrase.substring(begin).indexOf("_")) != -1) {
            count++;
            begin += index + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println(countWords(s));
    }
}
