import java.util.*;

class SwapNodes {
    static class Node {
        int data;
        int depth;
        int left;
        int right;

        private Node(int data, int depth) {
            this.data = data;
            this.depth = depth;
        }

        public String toString() {
            return data + " ";
        }

        // factory method that returns either a new regular Node or a null
        public static Node newNode(int data, int depth) {
            if (data == -1)
                return null;
            else
                return new Node(data, depth);
        }
    }

    static class BinaryTree {
        Node root;
        // keep track of where in the tree the parent is for the next 2 inserts
        // (left child and right child).
        // Queue<Node> insertQueue;
        // keep all nodes, including null's, in an array, to ease retrieving all
        // nodes at a given depth
        List<Node> allNodes;
        int insertIndex;
        // keep track of the start of each new depth in allNodes, since this
        // binary tree is not full
        // Map<Integer, Integer> depthIndices;
        List<Integer> depthBegins;

        public BinaryTree() {
            // root node is at depth 1
            root = Node.newNode(1, 1);
            // insertQueue = new LinkedList<>();
            // insertQueue.add(root);

            allNodes = new ArrayList<>();
            allNodes.add(root);

            insertIndex = 0;

            // depthIndices = new HashMap<>();
            // root is at depth 1 and is at index 0 in the allNodes list
            // depthIndices.put(1, 0);
            depthBegins = new ArrayList<>();
            depthBegins.add(0);
        }

        public void insert(int gauche, int droit) {
            // extract the first non-null Node from the queue and set the Node
            // as the parent for the left and right children
            /*
            Node parent = insertQueue.remove();
            while (parent == null) {
                parent = insertQueue.remove();
            }
            */
            Node parent = allNodes.get(insertIndex);
            while (parent == null) {
                insertIndex++;
                parent = allNodes.get(insertIndex);
            }

            // the child's depth is one more than that of the parent
            int childDepth = parent.depth + 1;
            Node left = Node.newNode(gauche, childDepth);
            Node right = Node.newNode(droit, childDepth);

            allNodes.add(left);
            allNodes.add(right);

            parent.left = allNodes.size() - 2;
            parent.right = allNodes.size() - 1;

            // insertQueue.add(left);
            // insertQueue.add(right);

            // the 2 children are at a new depth
            if (childDepth > depthBegins.size()) {
                if (left != null) {
                    depthBegins.add(allNodes.size() - 2);
                } else if (right != null) {
                    depthBegins.add(allNodes.size() - 1);
                }
            }
            System.out.println("parent " + parent.data + " added " + left + " and " + right + ": " + this);
        }

        public void swap(int depth) {
            int limit = depth > depthBegins.size() ? allNodes.size() : depthBegins.get(depth-1);
            for (int i = depthBegins.get(depth-2); i < limit; i++) {
                Node node = allNodes.get(i);
                // either parent node nis null or both children are null: no-op
                if (node == null || node.left == null && node.right == null) {
                    continue;
                // either left child or right child or both is not null
                } else {
                    // swap left child and right child within array
                    int tmp2 = node.left;
                    node.left = node.right;
                    node.right = tmp2;
                    // swap left and right child of the parent Node
                    Node tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;
                }
                /*
                if (node != null && node.left != null || node.right != null) {
                    // System.out.println("PRE, parent: " + parent + ", left: " + parent.left + ", right: " + parent.right);
                    Node tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;

                    // System.out.println("POST, parent: " + parent + ", left: " + parent.left + ", right: " + parent.right);

                    int leftIndex = (parentIndex + 1) * 2 - 1;
                    int rightIndex = (parentIndex + 1) * 2;
                    if (rightIndex < allNodes.size()) {
                        tmp = allNodes.get(leftIndex);
                        allNodes.set(leftIndex, allNodes.get(rightIndex));
                        allNodes.set(rightIndex, tmp);
                    }
                }
                */
            }
        }
        public void swapOld(int fondeur) {
            int depth = fondeur;
            while (true) {
                int parentStart = (1 << depth-1) - 1;
                int parentEnd = (1 << depth) - 2;
                if (parentEnd >= allNodes.size())
                    break;
                else {
                    depth += fondeur;
                    // System.out.println("swap, depth: " + depth + ", start: " + parentStart + ", end: " + parentEnd);
                    for (int parentIndex = parentStart; parentIndex <= parentEnd; parentIndex++) {
                        Node parent = allNodes.get(parentIndex);
                        if (parent != null) {
                            // System.out.println("PRE, parent: " + parent + ", left: " + parent.left + ", right: " + parent.right);
                            Node tmp = parent.left;
                            parent.left = parent.right;
                            parent.right = tmp;
                            // System.out.println("POST, parent: " + parent + ", left: " + parent.left + ", right: " + parent.right);

                            int leftIndex = (parentIndex + 1) * 2 - 1;
                            int rightIndex = (parentIndex + 1) * 2;
                            if (rightIndex < allNodes.size()) {
                                tmp = allNodes.get(leftIndex);
                                allNodes.set(leftIndex, allNodes.get(rightIndex));
                                allNodes.set(rightIndex, tmp);
                            }
                        }
                    }
                }
            }
        }

        public void inOrder(Node node, StringBuilder builder) {
            if (node != null) {
                inOrder(node.left, builder);
                builder.append(node);
                inOrder(node.right, builder);
            }
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            inOrder(root, builder);
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt();
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < nodes; i++) {
            int left = in.nextInt();
            int right = in.nextInt();
            tree.insert(left, right);
        }
        int swaps = in.nextInt();
        for (int i = 0; i < swaps; i++) {
            int depth = in.nextInt();
            System.out.println("depth: " + depth);
            tree.swap(depth);
            System.out.println("post-swap:");
            System.out.println(tree);
        }
    }
}
