import java.util.*;

public class Solution {
    static class Record {
        int positives;
        int negatives;
        int zeroes;
    }

    static Record tally(int[] array) {
        Record record = new Record();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0)
                record.positives++;
            else if (array[i] < 0)
                record.negatives++;
            else
                record.zeroes++;
        }
        return record;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        Record record = tally(arr);
        float size = (float)n;
        System.out.printf("%.6f\n%.6f\n%.6f\n", record.positives/size, record.negatives/size, record.zeroes/size);
    }
}
