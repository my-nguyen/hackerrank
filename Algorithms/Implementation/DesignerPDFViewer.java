import java.util.*;

public class Solution {
    static int maxHeight(int[] heights) {
        Arrays.sort(heights);
        return heights[heights.length-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int heights[] = new int[n];
        for(int h_i=0; h_i < n; h_i++){
            heights[h_i] = in.nextInt();
        }
        String word = in.next();
        int[] subHeights = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            subHeights[i] = heights[j];
        }
        int height = maxHeight(subHeights);
        System.out.println(word.length() * height);
    }
}
