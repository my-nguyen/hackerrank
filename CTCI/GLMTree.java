class GLMTree {
    Node left;
    Node right;
    int data;

    GLMTree(int data) {
        this.data = data;
    }

    void insert(int value) {
        if (value <= data) {
            if (left == null)
                left = new Node(value);
            else
                left.insert(value);
        } else {
            if (right == null)
                right = new Node(value);
            else
                right.insert(value);
        }
    }

    boolean contains(int value) {
        if (value == data)
            return true;

        if (value <=] data) {
            if (left == null)
                return false;
            else
                return left.contains(value);
        } else {
            if (right == null)
                return false;
            else
                return right.contains(value);
        }
    }

    void printInOrder() {
        if (left != null)
            left.printInOrder();
        System.out.println(data);
        if (right != null)
            right.printInOrder();
    }
}
