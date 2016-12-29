import java.util.*;

class Test3 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return data + "";
        }
    }

    static void swap(Node left, Node right) {
        Node tmp = left;
        left = right;
        right = tmp;
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        Node left = new Node(2);
        Node right = new Node(3);
        System.out.println("left: " + left + ", right: " + right);
        Node parent = new Node(1, left, right);
        nodes.add(parent);
        nodes.add(left);
        nodes.add(right);
        swap(left, right);
        System.out.println("left: " + left + ", right: " + right);
    }
}
