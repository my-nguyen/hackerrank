import java.util.*;

public class Solution {
    static boolean isAllAs(String string) {
        for (char letter : string.toCharArray()) {
            if (letter != 'a')
                return false;
        }
        return true;
    }

    static int countSubstring(String string) {
        return countSubstring(string, string.length());
    }

    static int countSubstring(String string, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == 'a')
                count++;
        }
        return count;
    }

    static long countAs(String string, long length) {
        if (!string.contains("a"))
            return 0;
        if (isAllAs(string))
            return length;
        int count = countSubstring(string);
        long quotient = length / string.length();
        int remainder = (int)(length % string.length());
        // System.out.println("count: " + count + ", quotient: " + quotient + ", remainder: " + remainder);
        long total = count*quotient + countSubstring(string, remainder);
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long count = countAs(s, n);
        System.out.println(count);
    }
}
