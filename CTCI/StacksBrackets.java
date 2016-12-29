import java.util.*;

class StacksBalanceBrackets {
    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new LinkedList<>();
        for (char bracket : expression.toCharArray()) {
            // if it's a left bracket, push it to the stack
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
            } else {
                // make sure stack is not empty
                if (stack.isEmpty())
                    return false;

                // if it's a right bracket, make sure there's a matching left
                // bracket
                char top = stack.pop();
                if (bracket == '}' && top != '{')
                    return false;
                if (bracket == ']' && top != '[')
                    return false;
                if (bracket == ')' && top != '(')
                    return false;
            }
        }

        // make sure stack is empty
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if (answer)
                System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
