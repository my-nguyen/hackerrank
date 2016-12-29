class GLMHashTable {
    LinkedList[] data;

    boolean put(String key, Person value) {
        int hash = hashCode(key);
        int index = convertToIndex(hash);
        LinkedList list = data[index];
        list.insert(key, value);
    }

    int hashCode(String key) {
    }
}
