import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }

        int acount = 0;
        for (int i = 0; i < m; i++) {
            if (a + apple[i] >= s && a + apple[i] <= t)
                acount++;
        }
        int ocount = 0;
        for (int i = 0; i < n; i++) {
            if (b + orange[i] >= s && b + orange[i] <= t)
                ocount++;
        }
        System.out.println(acount);
        System.out.println(ocount);
    }
}
