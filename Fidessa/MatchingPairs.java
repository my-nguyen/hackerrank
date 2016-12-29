    static int findMatchingPair(String input) {
        int lastIndex = -1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (Character.isUpperCase(current)) {
                char tmp = Character.toLowerCase(current);
                stack.push(tmp);
                System.out.println("push " + tmp);
            } else {
                if (i == 0 || stack.empty() || stack.peek() != current) {
                    System.out.println("unmatched, last index: " + lastIndex);
                    return lastIndex;
                }
                stack.pop();
                lastIndex = i;
                System.out.println("matched, last index: " + lastIndex);
            }
        }
        return lastIndex;
    }
