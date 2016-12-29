import java.util.*;

public class CircularArrayRotation {
    static void rotate(int[] array, int rotation) {
        rotation %= array.length;
        int[] tmp = new int[rotation];
        for (int i = 0; i < rotation; i++)
            tmp[i] = array[i+array.length-rotation];
        for (int i = array.length-1; i >= rotation; i--) {
            array[i] = array[i-rotation];
        }
        for (int i = 0; i < rotation; i++)
            array[i] = tmp[i];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        rotate(a, k);
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            System.out.println(a[m]);
        }
    }
}
