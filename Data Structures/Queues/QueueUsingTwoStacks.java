import java.util.*;

public class Solution {
    static class Queue {
        Stack<Integer> newestOnTop;
        Stack<Integer> oldestOnTop;

        Queue() {
            newestOnTop = new Stack<>();
            oldestOnTop = new Stack<>();
        }

        void enqueue(int data) {
            newestOnTop.push(data);
        }

        void dequeue() {
            if (oldestOnTop.empty()) {
                while (!newestOnTop.empty())
                    oldestOnTop.push(newestOnTop.pop());
            }
            oldestOnTop.pop();
        }

        int peek() {
            if (oldestOnTop.empty()) {
                while (!newestOnTop.empty())
                    oldestOnTop.push(newestOnTop.pop());
            }
            return oldestOnTop.peek();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int queries = in.nextInt();
        Queue queue = new Queue();
        for (int i = 0; i < queries; i++) {
            int operation = in.nextInt();
            switch (operation) {
            case 1:
                int data = in.nextInt();
                queue.enqueue(data);
                break;
            case 2:
                queue.dequeue();
                break;
            case 3:
                System.out.println(queue.peek());
            }
        }
    }
}
