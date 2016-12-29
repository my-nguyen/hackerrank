import java.util.*;

public class Solution {
    static int diff(int[][] array) {
        int diag1 = 0;
        for (int i = 0; i < array.length; i++) {
            diag1 += array[i][i];
        }
        int diag2 = 0;
        for (int i = 0; i < array.length; i++) {
            diag2 += array[i][array.length-i-1];
        }
        return Math.abs(diag1 - diag2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        System.out.println(diff(a));
    }
}
