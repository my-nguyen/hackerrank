class Trees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            data = value;
        }

        // this may not be necessary
        public String toString() {
            return data + " ";
        }
    };

    static class BinaryTree {
        public void preOrder(Node root) {
            if (root != null) {
                // since the problem requires an implementation of preOrder()
                // alone and no other code is given, we can't use Node.toString
                // here
                System.out.print(root.data + " ");
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        public void postOrder(Node root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.print(root.data + " ");
            }
        }

        public void inOrder(Node root) {
            if (root != null) {
                inOrder(root.left);
                System.out.print(root.data + " ");
                inOrder(root.right);
            }
        }

        public int getHeight(Node node) {
            int height;
          	if (node == null)
                height = -1;
            else {
                int left = getHeight(node.left);
                int right = getHeight(node.right);
                // height of the tree is the maximum height of the left branch
                // and the right branch
                height = 1 + Math.max(left, right);
            }
            return height;
        }

        void top_view(Node root) {
            topLeft(root.left);
            System.out.print(root.data + " ");
            topRight(root.right);
        }

        private void topLeft(Node root) {
            // go as far to the left branch as possible
            if (root.left != null)
                topLeft(root.left);
            // before printing data
            System.out.print(root.data + " ");
        }

        private void topRight(Node root) {
            System.out.print(root.data + " ");
            if (root.right != null)
                topRight(root.right);
        }

        public void LevelOrder(Node root) {
            Queue<Node> queue = new LinkedList<>();
            // add root as the only Node into queue, to start the loop
            queue.add(root);
            while (!queue.isEmpty()) {
                // remove top Node from queue
                Node top = queue.remove();
                System.out.print(top.data + " ");
                // add left and right children into queue, for processing later
                // within this loop
                if (top.left != null) {
                    queue.add(top.left);
                    if (top.right != null)
                        queue.add(top.right);
                }
            }
        }

        public Node Insert(Node root, int value) {
            return insertOrdered(root, value);
        }

        private Node insertOrdered(Node root, int value) {
            Node current = new Node();
            current.data = value;
            // tree currently empty
            if (root == null)
                root = current;
            else {
                // go to the left branch
                if (value < root.data) {
                    // reached the end of the left branch: insert new Node there
                    if (root.left == null)
                        root.left = current;
                    // not the end of the left branch: keep going left
                    else
                        insertOrdered(root.left, value);
                } else {
                    if (root.right == null)
                        root.right = current;
                    else
                        insertOrdered(root.right, value);
                }
            }
            return root;
        }

        void decode(String string, Node root) {
            Node current = root;
            StringBuilder code = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                // go left if current character is '0', and go right otherwise
                current = string.charAt(i) == '0' ? current.left : current.right;
                // encountered a leaf node
                if (current.left == null && current.right == null) {
                    // save the data in the leaf node
                    code.append(current.data);
                    // go back to root
                    current = root;
                }
            }
            System.out.print(code);
        }

        Node lca(Node root, int v1, int v2) {
            List<Node> path1 = new ArrayList<>();
            // obtain the path containing all nodes leading up to that
            // containing v1
            search(root, v1, path1);
            List<Node> path2 = new ArrayList<>();
            search(root, v2, path2);
            // find the last common node between path1 and path2
            Node common = lastCommonNode(path1, path2);
            // that last common node is the lowest common ancestor
            return common;
        }

        private void search(Node node, int value, List<Node> path) {
            // add current Node into the path
            path.add(node);
            // go left if value is smaller
            if (value < node.data) {
                search(node.left, value, path);
            } else if (value > node.data) {
                search(node.right, value, path);
            }
        }

        private Node lastCommonNode(List<Node> path1, List<Node> path2) {
            int i = 0;
            while (i < path1.size() && i < path2.size() && path1.get(i) == path2.get(i)) {
                i++;
            }
            return path1.get(i-1);
        }

/*
        Node insertUnordered(Node root, int data) {
            if (root == null)
                return new Node(data);
            else {
                queue<Node> queue;
                queue.push(root);
                while (!queue.empty()) {
                    Node top = queue.front();
                    queue.pop();
                }
            }
        }
        */
    };

    public static void main(String[] args) {
        BinaryTree tree;
        Node root = 0;
        int size;
        cin >> size;
        while (size-- > 0) {
            int data;
            cin >> data;
            root = tree.insert(root, data);
            cout << "inserted " << data << ", height: " << tree.getHeight(root) << endl;
        }
        tree.top_view(root);
        cout << endl;

        return 0;
    }
}
