import java.util.*;

public class Solution {
    static int[] readTriplet(Scanner in) {
        int[] triplet = new int[3];
        for (int i = 0; i < 3; i++)
            triplet[i] = in.nextInt();
        return triplet;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] atriplet = readTriplet(in);
        int[] btriplet = readTriplet(in);
        int acount = 0, bcount = 0;
        for (int i = 0; i < 3; i++) {
            if (atriplet[i] > btriplet[i])
                acount++;
            else if (atriplet[i] < btriplet[i])
                bcount++;
        }
        System.out.println(acount + " " + bcount);
    }
}
