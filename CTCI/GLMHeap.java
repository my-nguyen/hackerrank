class GLMHeap {
    int capacity = 10;
    int size = 0;
    int[] items = new int[capacity];

    int leftChildIndex(int parentIndex) { return 2*parentIndex + 1; }
    int rightChildIndex(int parentIndex) { return 2*parentIndex + 2; }
    int parentIndex(int childIndex) { return (childIndex-1) / 2; }
    boolean hasLeftChild(int index) { return leftChildIndex(index) < size; }
    boolean hasRightChild(int index) { return rightChildIndex(index) < size; }
    boolean hasParent(int index) { return parentIndex(index) >= 0; }
    int leftChild(int index) { return items[leftChildIndex(index)]; }
    int rightChild(int index) { return items[rightChildIndex(index)]; }
    int parent(int index) { return items[parentIndex(index)]; }

    void swap(int left, int right) {
        int tmp = items[left];
        items[left] = items[right];
        items[right] = tmp;
    }

    void ensureCapacity() {
        if (size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    int peek() {
        if (size == 0)
            throw new IllegalStateException();
        return items[0];
    }

    int poll() {
        if (size == 0)
            throw new IllegalStateException();
        // get the value
        int item = items[0];
        // move last element into first
        items[0] = ites[size-1];
        // shrink array size
        size--;
        heapifyDown();
        return item;
    }

    void add(int item) {
        ensureCapacity();
        // add item to last spot
        items[size] = item;
        // increase size
        size++;
        heapifyUp();
    }

    void heapifyUp() {
        // start with the very last element added
        int index = size - 1;
        // walk up as long as there's a parent item and this child item is out
        // of order
        while (hasParent(index) && parent(index) > items[index]) {
            // swap child with parent
            swap(parentIndex(index), index);
            // walk upward
            index = parentIndex(index);
        }
    }

    void heapifyDown() {
        // start with root element
        int index = 0;
        // only check for left child: no need to check for right child if
        // there's no left child
        while (hasLeftChild(index)) {
            int smallerIndex = leftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerIndex = rightChildIndex(index);
            }
            if (items[index] < items[smallerIndex])
                break;

            swap(index, smallerIndex);
            index = smallerIndex;
        }
    }
}
