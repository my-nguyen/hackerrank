import java.util.*;

public class Solution {
    static int minBugCount(String board) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char bug : board.toCharArray()) {
            if (bug != '_') {
                Integer count = counts.get(bug);
                count = count == null ? 1 : count+1;
                counts.put(bug, count);
            }
        }

        if (counts.size() == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int count : counts.values())
            min = Math.min(min, count);
        return min;
    }

    static boolean containsSpace(String board) {
        for (char c : board.toCharArray()) {
            if (c == '_')
                return true;
        }
        return false;
    }

    static boolean isHappy(String board) {
        int length = board.length();
        if (board.charAt(0) != board.charAt(1) || board.charAt(length-2) != board.charAt(length-1))
            return false;
        for (int i = 1; i < board.length()-1; i++) {
            if (board.charAt(i-1) != board.charAt(i) && board.charAt(i) != board.charAt(i+1))
                return false;
        }
        return true;
    }

    static String move(String board) {
        int minCount = minBugCount(board);
        if (minCount == 0)
            return "YES";
        if (minCount == 1)
            return "NO";
        if (containsSpace(board))
            return "YES";
        return isHappy(board) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String board = in.next();
            System.out.println(move(board));
        }
    }
}
