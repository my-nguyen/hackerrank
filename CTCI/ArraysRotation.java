class ArraysLeftRotation {
    static void leftRotateArray(int[] array, int rotateBy) {
        int[] tmp = new int[rotateBy];
        // save the subarray that needs to rotate to the back
        for (int i = 0; i < rotateBy; i++)
            tmp[i] = array[i];
            // shift left the whole array over, by a number (rotateBy)
        for (int i = 0; i < array.length-rotateBy; i++)
            array[i] = array[i+rotateBy];
        // copy the saved subarray back to the end of the array
        for (int i = 0; i < rotateBy; i++)
            array[array.length-rotateBy+i] = tmp[i];
    }

    public static void main(String[] args) {

    }
}
