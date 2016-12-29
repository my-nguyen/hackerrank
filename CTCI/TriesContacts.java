import java.util.*;

class Trie {
    static class Node {
        Node[] children;
        int count;
        boolean complete;

        Node() {
            children = new Node[MAX_CHILDREN];
            count = 0;
            complete = false;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0, tmp = 0; i < MAX_CHILDREN && tmp < count; i++) {
                if (children[i] != null) {
                    char letter = (char)('a' + i);
                    builder.append(letter).append(count);
                    if (complete)
                        builder.append("*");
                    tmp++;
                }
            }
            return builder.toString();
        }
    }

    static final int MAX_CHILDREN = 26;
    Node root;

    Trie() {
        root = new Node();
    }

    // this assumes words are distinct and there's no duplicate words
    void add(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            // increase count on each Node containing a character in the path to
            // compose the whole word
            node.count++;
            // System.out.println("added " + node);
            node = node.children[index];
        }
        // mark the end of the word as complete
        node.complete = true;
    }

    int find(String word) {
        // System.out.println("root: " + root);
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            node = node.children[index];
            if (node == null) {
                return 0;
            }
        }
        // System.out.println("find " + word + ": " + node.count);
        return node.count;
    }
}

class TriesContacts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie root = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add"))
                root.add(contact);
            else if (op.equals("find"))
                System.out.println(root.find(contact));
        }
    }
}
