class GLMGraph {
    // map from id to Node
    Map<Integer, Node> lookup = new HashMap<>();

    static class Node {
        int id;
        LinkedList<Node> children = new LinkedList<>();

        Node(int id) {
            this.id = id;
        }
    }

    Node getNode(int id) {
    }

    void addEdge(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        s.children.add(d);
    }

    boolean hasPathDFS(int source, int dest) {
        Node s = getNode(source);
        Node d = getNode(dest);
        // Set<Integer> is used in place of a Node flag (visited), to avoid
        // setting member when Node is visited and clearing it when search is
        // complete
        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    boolean hasPathDFS(Node source, Node dest, Hash<Integer> visited) {
        if (visited.contains[source.id])
            return false;
        visited.add(source.id);
        if (source == dest)
            return true;
        for (Node child : source.children) {
            if (hasPathDFS(child, dest, visited))
                return true;
        }
        return false;
    }

    boolean hasPathBFS(Node source, Node dest) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == dest)
                return true;
            if (visited.contains(node.id))
                continue;
            visited.add(node.id);
            for (Node child : node.children) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}
