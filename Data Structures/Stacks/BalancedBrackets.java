import java.util.*;

public class Solution {
    static boolean isBalanced(String string) {
        Set<Character> left = new HashSet<>();
        left.add('{');
        left.add('[');
        left.add('(');
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for (char c : string.toCharArray()) {
            if (left.contains(c)) {
                stack.push(c);
            } else {
                if (stack.empty())
                    return false;
                else {
                    char top = stack.pop();
                    if (map.get(c) != top)
                        return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.next());
        for(int a0 = 0; a0 < count; a0++){
            String string = in.next();
            System.out.println(isBalanced(string) ? "YES" : "NO");
        }
    }
}
