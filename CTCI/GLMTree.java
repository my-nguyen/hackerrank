class GLMTree {
    Node left;
    Node right;
    int data;

    GLMTree(int data) {
        this.data = data;
    }

    void insert(int value) {
        // look left
        if (value <= data) {
            // there's no left child: insert a new node as the left child
            if (left == null)
                left = new Node(value);
            // there's a left child: recursively insert value into the left child
            else
                left.insert(value);
        // look right
        } else {
            if (right == null)
                right = new Node(value);
            else
                right.insert(value);
        }
    }

    boolean contains(int value) {
        // if I'm there, return true
        if (value == data)
            return true;

        // otherwise, check left branch
        if (value <= data) {
            // if there's no left branch, then the tree doesn't contain value
            if (left == null)
                return false;
            // if there's a left branch, recursively search in the left branch
            else
                return left.contains(value);
        // check right branch
        } else {
            if (right == null)
                return false;
            else
                return right.contains(value);
        }
    }

    void printInOrder() {
        // first, print left child
        if (left != null)
            left.printInOrder();
        // then, print root data
        System.out.println(data);
        // last, print right child
        if (right != null)
            right.printInOrder();
    }
}
