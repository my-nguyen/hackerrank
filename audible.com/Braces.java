    static final char[] LEFT_BRACES = { '{', '[', '(' };
    static final char[] RIGHT_BRACES = { '}', ']', ')' };

    private static boolean isLeftBrace(char c) {
        for (char brace : LEFT_BRACES) {
            if (brace == c)
                return true;
        }
        return false;
    }

    private static boolean bracesMatch(char leftBrace, char rightBrace) {
        for (int i = 0; i < LEFT_BRACES.length; i++) {
            if (LEFT_BRACES[i] == leftBrace)
                return RIGHT_BRACES[i] == rightBrace;
        }
        return false;
    }

    private static boolean isBalanced(String value) {
        Stack<Character> stack = new Stack<>();
        for (char c : value.toCharArray()) {
            if (isLeftBrace(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !bracesMatch(stack.pop(), c))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    static String[] braces(String[] values) {
        String[] results = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            results[i] = isBalanced(values[i]) ? "YES" : "NO";
        }
        return results;
    }
