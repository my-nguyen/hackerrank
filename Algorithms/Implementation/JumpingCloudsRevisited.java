import java.util.*;

public class Solution {
    static int energyRemains(int[] clouds, int jump) {
        int energy = 100;
        for (int i = 0; i == 0 || i % clouds.length != 0; i += jump) {
            energy -= 1 + 2*clouds[i];
        }
        return energy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }

        System.out.println(energyRemains(c, k));
    }
}
