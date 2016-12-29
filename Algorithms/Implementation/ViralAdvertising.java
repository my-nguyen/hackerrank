import java.util.*;

public class Solution {
    static int countLikes(int days) {
        int count = 0;
        int current = 5 / 2;
        for (int i = 1; i <= days; i++) {
            count += current;
            current = current * 3 / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int days = in.nextInt();
        System.out.println(countLikes(days));
    }
}
