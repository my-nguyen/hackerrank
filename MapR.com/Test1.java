import java.util.*;

class Test1 {
    public static void main(String[] args) {
        int[] array = { 1, 3, 6, 9 };
        System.out.println("search 4: " + Arrays.binarySearch(array, 4));
        System.out.println("search 5: " + Arrays.binarySearch(array, 5));
        System.out.println("search 6: " + Arrays.binarySearch(array, 6));
        System.out.println("search 8: " + Arrays.binarySearch(array, 8));
        System.out.println("search 9: " + Arrays.binarySearch(array, 9));
        System.out.println("search 10: " + Arrays.binarySearch(array, 10));
    }
}
