public class Solution {
    private static int lonelyInteger(int[] array) {
        int result = 0;
        for (int value : array) {
            result ^= value;
        }
        return result;
    }
}
