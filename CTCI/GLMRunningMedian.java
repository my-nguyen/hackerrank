class GLMRunningMedian {
    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        // if lower half is empty, or the number is less than the max value of the lower heap
        if (lowers.size() == 0 || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        // if the size of the 2 heaps differ by 2 (but shouldn't be more than 2)
        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            // remove the top element from the bigger-size heap
            // and add that element to the smaller-size heap
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        // if the size of the 2 heaps are the same, take the average of the 2 top elements
        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        // else if the size of the heaps differ by 1, just take the top element of the bigger-size heap
        } else {
            return biggerHeap.peek();
        }
    }

    public static double[] getMedians(int[] array) {
        // max heap on the lower half
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        // min heap on the upper half
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        // the running medians
        double[] medians = new double[array.length];

        for (int i = 0; i < array.length; i++) {
            // extract the array element
            int number = array[i];
            // add the element into either the lower heap or the higher heap
            addNumber(number, lowers, highers);
            // make sure the size of the 2 heaps differ by 0 or 1
            rebalance(lowers, highers);
            // get the running median so far
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }
}
