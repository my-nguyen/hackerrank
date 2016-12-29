class GLMMergeSort {
    static void mergesort(int[] array) {
        mergesort(array, new int[array.length], 0, array.length-1);
    }

    static void mergesort(int[] array, int[] tmp, int left, int right) {
        if (left >= right)
            return;
        int middle = (left + right) / 2;
        mergesort(array, tmp, left, middle);
        mergesort(array, tmp, middle+1, right);
        mergeHalves(array, tmp, left, right);
    }

    static void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftSart + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tmp[index] = array[left];
                left++;
            } else {
                tmp[index] = array[right];
                right--;
            }
            index++;
        }

        System.arrayCopy(array, left, tmp, index, leftEnd-left+1);
        System.arrayCopy(array, right, tmp, index, rightEnd-right+1);
        System.arrayCopy(tmp, leftStart, array, leftStart, size);
    }
}
