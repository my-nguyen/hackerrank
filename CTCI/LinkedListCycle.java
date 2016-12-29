import java.util.*;

class Node {
    int data;
    Node next;
}

class LinkedListDetectACycle {
    static boolean hasCycle(Node head) {
        if (head == null)
            return false;

        // the Node class is defined by the system outside my control, so I
        // won't be able to add methods hashCode() and equals() to the Node
        // class for use by method contains(). but use of Set<Node> is ok since
        // I only need to compare whether two objects are the same and not
        // whether the data in the two objects are the same
        Set<Node> list = new HashSet<>();
        Node current = head;
        while (current != null) {
            if (list.contains(current))
                return true;
            list.add(current);
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
