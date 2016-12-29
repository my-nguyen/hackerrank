import java.util.*;

public class Solution {
    static class Node {
        final int MAX_CHARACTERS = 26;
        Node[] children = new Node[MAX_CHARACTERS];
        int size = 0;

        public void add(String s) {
            add(s, 0);
        }

        private void add(String s, int index) {
            size++;
            if (index < s.length()) {
                char current = s.charAt(index);
                Node child = children[current - 'a'];
                if (child == null) {
                    child = new Node();
                    children[current - 'a'] = child;
                }
                child.add(s, index+1);
            }
        }

        public void remove(String s) {
            remove(s, 0);
        }

        private void remove(String s, int index) {
            size--;
            if (index < s.length()) {
                char current = s.charAt(index);
                Node child = children[current - 'a'];
                child.remove(s, index+1);
            }
        }

        public List<Integer> count(String s) {
            List<Integer> list = new ArrayList<>();
            count(s, 0, list);
            return list;
        }

        private void count(String s, int index, List<Integer> list) {
            if (index < s.length()) {
                char current = s.charAt(index);
                Node child = children[current - 'a'];
                if (child != null) {
                    list.add(child.size);
                    child.count(s, index+1, list);
                }
            }
        }
    }

    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int queries = Integer.parseInt(in.nextLine());
        Node node = new Node();
        for (int i = 0; i < queries; i++) {
            String line = in.nextLine();
            String[] tokens = line.split(" ");
            String sign = tokens[0];
            String word = tokens[1];
            if (sign.equals("+")) {
                List<Integer> list = node.count(word);
                int sum = 0;
                for (int j = 0; j < list.size(); j++) {
                    sum += (j+1) * list.get(j);
                }
                System.out.println(sum);
                node.add(word);
            } else {
                node.remove(word);
            }
        }
    }
}
