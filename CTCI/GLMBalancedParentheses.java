class GLMBalancedParentheses {
    public static char[][] TOKENS = { {'{', '}'}, {'[', ']'}, {'(', ')'} };

    // whether a character is an open term: "{", "[", or "("
    public static boolean isOpenTerm(char c) {
        for (char[] array : TOKENS) {
            if (array[0] == c)
                return true;
        }
        return false;
    }

    // whether openTerm is an open term and if so, whether it matches
    // with a corresponding close term
    public static boolean matches(char openTerm, char closeTerm) {
        for (char[] array : TOKENS) {
            if (array[0] == openTerm)
                return array[1] == closeTerm;
        }
        return false;
    }

    // whether a string expression has all its open terms match with
    // their corresponding close terms
    public static boolean isBalanced(String expression) {
        // storage of all open terms encountered and not popped so far
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            // if character is an open term, push it into stack
            if (isOpenTerm(c)) {
                stack.push(c);
            // if character is a close term, see if it matches with
            // the last-pushed open term
            } else {
                if (stack.isEmpty() || !matches(stacks.pop(), c))
                    return false;
            }
        }

        // if there remains some elements (open terms) in the stack
        // at this point, then the expression is not balanced.
        // otherwise the expression is balanced.
        return stack.isEmpty();
    }
}
