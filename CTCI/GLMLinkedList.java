class GLMLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    void append(int data) {
        if (head == null)
            head = new Node(data);
        else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = new Node(data);
        }
    }

    void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    void delete(int data) {
        if (head == null)
            return;
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}
