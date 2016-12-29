    static int ThirdLargest(int[] arr) {
        Queue<Integer> queue = new PriorityQueue();
        queue.add(arr[0]);
        queue.add(arr[1]);
        queue.add(arr[2]);
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] > queue.peek()) {
                queue.remove();
                queue.add(arr[i]);
            }
        }
        return queue.peek();
    }
