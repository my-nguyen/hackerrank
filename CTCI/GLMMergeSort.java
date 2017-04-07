class GLMMergeSort {
    static void mergesort(int[] array) {
        // use one temporary int array for all calls to mergeHalves()
        mergesort(array, new int[array.length], 0, array.length-1);
    }

    static void mergesort(int[] array, int[] tmp, int left, int right) {
        // base case
        if (left >= right)
            return;
        // otherwise, find a middle point
        int middle = (left + right) / 2;
        // recursively merge-sort from left to middle
        mergesort(array, tmp, left, middle);
        // recursively merge-sort from middle to right
        mergesort(array, tmp, middle+1, right);
        // merge the 2 halves that have been merge-sorted
        mergeHalves(array, tmp, left, right);
    }

    static void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftSart + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        
        // walk thru the 2 halves and copy over the elements
        while (left <= leftEnd && right <= rightEnd) {
            // copy the smaller element (be it on the left or the right) into tmp
            if (array[left] <= array[right]) {
                tmp[index] = array[left];
                left++;
            } else {
                tmp[index] = array[right];
                right--;
            }
            index++;
        }

        // at this point, one of the 2 halves are exhausted
        // copy the remainder of the half (with elements still in it) into tmp
        System.arrayCopy(array, left, tmp, index, leftEnd-left+1);
        System.arrayCopy(array, right, tmp, index, rightEnd-right+1);
        // copy tmp back into array
        System.arrayCopy(tmp, leftStart, array, leftStart, size);
    }
}
