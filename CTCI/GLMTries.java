class GLMTries {
    private static int NUMBER_OF_CHARACTERS = 26;
    // all 26 possible children, which is the number of characters in the alphabet
    Node[] children = new Node[NUMBER_OF_CHARACTERS];
    // the actual number of children
    int size = 0;

    private static int getCharIndex(char c) {
        return c - 'a';
    }

    private Node getNode(char c) {
        return children[getCharIndex(c)];
    }

    private void setNode(char c, Node node) {
        children[getCharIndex(c)] = node;
    }

    public void add(String s) {
        add(s, 0);
    }

    private void add(String s, int index) {
        size++;
        if (index == s.length())
            return;
        char current = s.charAt(index);
        Node child = getNode(current);
        // add a new Node if none exists at the current index
        if (child == null) {
            child = new Node();
            setNode(current, child);
        }
        // recurse with index incremented
        child.add(s, index+1);
    }

    public int findCount(String s, int index) {
        // if at the end of string
        if (index == s.length())
            return size;
        // get the next Node
        Node child = getNode(s.charAt(index));
        if (child == null)
            return 0;
        // recurse with index incremented
        return child.findCount(s, index+1);
    }
}
