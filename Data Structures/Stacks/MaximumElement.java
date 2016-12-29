import java.util.*;

public class Solution {
    static int findMax(Stack<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (int value : stack)
            max = Math.max(max, value);
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            int operation = in.nextInt();
            switch (operation) {
            case 1:
                int value = in.nextInt();
                stack.push(value);
                max = Math.max(max, value);
                break;
            case 2:
                stack.pop();
                max = findMax(stack);
                break;
            case 3:
                System.out.println(max);
            }
        }
    }
}
