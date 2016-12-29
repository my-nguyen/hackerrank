import java.util.*;

public class Solution {
    static Stack<Operation> stack = new Stack<>();
    static StringBuilder builder = new StringBuilder();

    static class Operation {
        int code;
        String word;

        Operation(int code, String word) {
            this.code = code;
            this.word = word;
        }
    }

    static void append(String word) {
        stack.push(new Operation(1, word));
        builder.append(word);
    }

    static void delete(int size) {
        String word = builder.substring(builder.length()-size);
        builder.delete(builder.length()-size, builder.length());
        stack.push(new Operation(2, word));
    }

    static void print(int position) {
        System.out.println(builder.charAt(position-1));
    }

    static void undo() {
        Operation top = stack.pop();
        switch (top.code) {
        case 1:
            builder.delete(builder.length()-top.word.length(), builder.length());
            break;
        case 2:
            builder.append(top.word);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = Integer.parseInt(in.next());
        for (int i = 0; i < count; i++) {
            int operation = Integer.parseInt(in.next());
            switch (operation) {
            case 1:
                String word = in.next();
                append(word);
                break;
            case 2:
                int size = Integer.parseInt(in.next());
                delete(size);
                break;
            case 3:
                int position = Integer.parseInt(in.next());
                print(position);
                break;
            case 4:
                undo();
            }
        }
    }
}
