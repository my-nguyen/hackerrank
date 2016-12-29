import java.util.*;

class CamelCase {
    static int countUpper(String string) {
        int count = 1;
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.next();
        int count = countUpper(string);
        System.out.println(count);
    }
}
