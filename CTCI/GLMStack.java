class GLMStack {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top;

    boolean isEmpty() {
        return top == null;
    }

    int peek() {
        return top.data;
    }

    void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    int pop() {
        int data = top.data;
        top = top.next;
        return data;
    }
}
