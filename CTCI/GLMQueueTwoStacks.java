class GLMQueueTwoStacks {
    public static class MyQueue<T> {
        private Stack<T> stackNewestOnTop = new Stack<>();
        private Stack<T> stackOldestOnTop = new Stack<>();

        // push new value into stackNewestOnTop
        void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        T peek() {
            shiftStacks();
            return stackOldestOnTop.peek();
        }

        T dequeue() {
            shiftStacks();
            return stackOldestOnTop.pop();
        }

        private void shiftStacks() {
            // only when stackOldestOnTop is empty
            if (stackOldestOnTop.isEmpty()) {
                // move elements from stackNewestOnTop to stackOldestOnTop
                // so that newest elements stay at the bottom and oldest
                // elements stay at the top of stackOldestOnTop
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }
}
