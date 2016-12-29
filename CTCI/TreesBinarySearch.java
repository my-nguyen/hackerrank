class Node {
    int data;
    Node left;
    Node right;
}

class TreesIsThisABinarySearchTree {
    void recurse(Node node, List<Integer> array) {
        if (node == null)
            return;

        recurse(node.left, array);
        array.add(node.data);
        recurse(node.right, array);
    }

    boolean checkBST(Node root) {
        List<Integer> array = new ArrayList<>();
        recurse(root, array);
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= array.get(i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
