class GLMQuickSort {
    static void quicksort(int[] array) {
        quicksort(array, 0, array.length-1);
    }

    void quicksort(int[] array, int left, int right) {
        // base case
        if (left >= right)
            return;
        // otherwise, pick pivot as the element at the end
        int pivot = array[right];
        // partition the array around the pivot
        int index = partition(array, left, right, pivot);
        // recursive call for partition between left and partition
        quicksort(array, left, index-1);
        // recursive call for partition between partition and right
        quicksort(array, index, right);
    }

    int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            // look for an element on the left that's bigger than pivot
            while (array[left] < pivot)
                left++;
            // look for an element on the right that's smaller than pivot
            while (array[right] > pivot)
                right--;

            // swap if left index is to the left of right
            if (left < right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        // return partition point
        return left;
    }
}
