class GLMLinkedListCycle {
    boolean hasCycle(Node head) {
        if (head == null)
            return false;
        Node fast = head.next;
        Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            // if fast pointer catches up with slow pointer, there's a loop
            if (fast == slow)
                return true;

            // fast pointer advances 2 nodes at a time
            fast = fast.next.next;
            // slow pointer advances 1 node at a time
            slow = slow.next;
        }
        // if fast pointer reaches null, then there's no loop
        return false;
    }
}
