// a binary search tree (BST) is one in which, for a given node (root), all the nodes to
// the left are smaller than root, and all the nodes to the right are bigger than root
// 1. first approach (incorrect) to checking if a tree is a BST, is to walk thru the tree, and
// for every given node, check to make sure the left and the right nodes are in the right order
// in other words: node.left < node < node.right
// 2. second approach (correct but inefficient): get the biggest node to the left and
// get the smallest node to the right
// in other words: max(left subtree) < node < min(right subtree)
// 3. third approach (best): given a root node, then everything in the left branch
// must be between the minimum integer and the value of root, and everything in the right
// branch must be between the value of root and the maximum integer. Going to the left node,
// then to the right of that left: all nodes in this subtree must be between the value of left node
// and the value of root. so this range can be used as argument to a recursive function to make sure
// the branches under exam is within that range
class GLMBinarySearchTree {
    // min and max are inclusive
    private boolean checkBST(Node root, int min, int max) {
        // base case: root is null means tree is BST
        if (root == null)
            return true;
        // if root value is out of order, then tres is not BST
        if (root.data < min || root.data > max)
            return false;
        // recursively check both left and right subtrees
        // for left subtree, max must be less than root value
        // for right subtree, min must be greater than root value
        return checkBST(root.left, min, root.data-1) && checkBST(root.right, root.data+1, max);
    }

    public boolean checkBST(Node root) {
        // initially, node is root, min is integer min, and max is integer max
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
