import java.util.*;

class MinimizeMaxMin {
    static int diff(int[] array) {
        Arrays.sort(array);
        int countMin = 1;
        int min = array[0];
        for (int i = 1; array[i] == min; i++)
            countMin++;
        int countMax = 1;
        int max = array[array.length-1];
        for (int i = array.length-2; array[i] == max; i--)
            countMax++;
        if (countMin == 1 && countMax == 1) {
            int diffMin = array[1] - array[0];
            int diffMax = array[array.length-1] - array[array.length-2];
            if (diffMin > diffMax)
                return array[array.length-1] - array[1];
            else
                return array[array.length-2] - array[0];
        } else if (countMin == 1) {
            return array[array.length-1] - array[1];
        } else if (countMax == 1) {
            return array[array.length-2] - array[0];
        } else {
            return array[array.length-1] - array[0];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(diff(array));
    }
}
