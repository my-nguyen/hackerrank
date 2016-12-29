class GLMQueueTwoStacks {
    public static class MyQueue<T> {
        private Stack<T> stackNewestOnTop = new Stack<>();
        private Stack<T> stackOldestOnTop = new Stack<>();

        void enqueue(T value) {
            stackNewestOnTop.push(value);
        }

        T peek() {
            // move elements from stackNewestOnTop to stackOldestOnTop
            shiftStacks();
            return stackOldestOnTop.peek();
        }

        T dequeue() {
            shiftStacks();
            return stackOldestOnTop.pop();
        }

        private void shiftStacks() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }
    }
}
