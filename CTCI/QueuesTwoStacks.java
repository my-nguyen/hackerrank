import java.util.*;

class QueuesATaleOfTwoStacks {
    static class MyQueue<T> {
        // class Stack is deprecated. using it causes a time out when the data
        // set has 100,000 elements
        // Stack<T> inStack = new Stack<>();
        // Stack<T> outStack = new Stack<>();
        // so Stack is replaced with interface Deque, which is implemented by
        // LinkedList (standard) and ArrayDeque (array based)
        Deque<T> inStack = new LinkedList<>();
        Deque<T> outStack = new LinkedList<>();

        // implementation 1: costly enqueue() and cheap dequeue()
        // this implementation runs out of time, because of the 2 while loops
        // to transfer elements from one stack to another
        public void enqueue1(T value) { // Push onto newest stack
            while (outStack.peek() != null) {
                T element = outStack.pop();
                inStack.push(element);
            }
            inStack.push(value);
            while (inStack.peek() != null)
                outStack.push(inStack.pop());
        }

        public T dequeue1() {
            return outStack.pop();
        }

        public T peek1() {
            return outStack.peek();
        }

        // implementation 2: cheap enqueue() and costly dequeue()
        // this implementation makes the time
        public void enqueue(T value) {
            // just push new value onto inStack
            inStack.push(value);
        }

        public T dequeue() {
            if (inStack.peek() == null && outStack.peek() == null)
                return null;

            // if outStack is empty, transfer all elements from inStack to
            // outStack, while reversing the storage order of the elements
            if (outStack.peek() == null) {
                while (inStack.peek() != null)
                    outStack.push(inStack.pop());
            }
            return outStack.pop();
        }

        public T peek() {
            if (outStack.peek() != null)
                return outStack.peek();

            // if outStack is empty, transfer all elements from inStack to
            // outStack, while reversing the storage order of the elements
            while (inStack.peek() != null)
                outStack.push(inStack.pop());
            return outStack.peek();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
