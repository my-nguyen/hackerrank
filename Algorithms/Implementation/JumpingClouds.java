import java.util.*;

public class Solution {
    static int countJumps(int[] clouds) {
        int count = 0;
        int i = 0;
        while (i < clouds.length-1) {
            if (i+2 < clouds.length && clouds[i+2] == 0)
                i += 2;
            else
                i += 1;
            // i += clouds[i+2] == 0 ? 2 : 1;
            count++;
            // System.out.println("i: " + i + ", count: " + count);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int count = countJumps(c);
        System.out.println(count);
    }
}
