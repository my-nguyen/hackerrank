import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int countPairs(int[] colors) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            Integer count = counts.get(colors[i]);
            if (count == null)
                counts.put(colors[i], 1);
            else
                counts.put(colors[i], count+1);
        }
        int count = 0;
        for (int value : counts.values()) {
            count += value / 2;
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

        System.out.println(countPairs(c));
    }
}
