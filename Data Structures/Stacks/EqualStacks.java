import java.util.*;

public class Solution {
    static class Queue {
        // accumulated heights so far
        int[] heights;
        int top;

        Queue(int[] array) {
            // heights has one extra element at the end containing 0, so
            // when all elements are popped out of queue, the height is 0.
            heights = new int[array.length + 1];
            heights[array.length] = 0;
            for (int i = array.length-1; i >= 0; i--) {
                heights[i] = array[i] + heights[i+1];
            }
            top = 0;
        }

        int height() {
            return heights[top];
        }

        void dequeue() {
            top++;
        }
    }

    static Queue maxQueue(Queue queue1, Queue queue2) {
        return queue1.height() > queue2.height() ? queue1 : queue2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }
        Queue queue1 = new Queue(h1);

        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }
        Queue queue2 = new Queue(h2);

        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }
        Queue queue3 = new Queue(h3);

        while (queue1.height() != queue2.height() || queue1.height() != queue3.height()) {
            while (queue1.height() != queue2.height()) {
                Queue bigQueue = maxQueue(queue1, queue2);
                bigQueue.dequeue();
            }
            while (queue1.height() != queue3.height()) {
                Queue bigQueue = maxQueue(queue1, queue3);
                bigQueue.dequeue();
            }
        }
        System.out.println(queue1.height());
    }
}
