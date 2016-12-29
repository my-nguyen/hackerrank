class GLMQueue {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;
    Node tail;

    boolean isEmpty() {
        return head == null;
    }

    int peek() {
        return head.data;
    }

    void add(int data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null)
            head = node;
    }

    int remove() {
        int data = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        return data;
    }
}
