import java.util.*;
import java.math.*;

public class Solution {
    static BigInteger sum(int[] array) {
        BigInteger result = BigInteger.ZERO;
        for (int number : array) {
            result = result.add(BigInteger.valueOf(number));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        System.out.println(sum(arr));
    }
}
