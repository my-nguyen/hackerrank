import java.util.*;

public class Solution {
    static int countOdds(int[] persons) {
        int count = 0;
        for (int person : persons) {
            if (person % 2 == 1)
                count++;
        }
        return count;
    }

    static int firstOdd(int[] persons, int start) {
        for (int i = start; i < persons.length; i++) {
            if (persons[i] % 2 == 1)
                return i;
        }
        return -1;
    }

    static String giveBreads(int[] persons) {
        int odds = countOdds(persons);
        int breads = 0;
        int index = 0;
        // quit when odd count is either 1 or 0
        while (odds > 1) {
            // find the first person from left with an odd number of breads
            index = firstOdd(persons, index);
            // System.out.println("index: " + index + ", persons[index]: " + persons[index] + ", persons[index+1]: " + persons[index+1]);
            // distribute one bread each to that first person and the next person
            // note the next person cannot be out of bounds, since odd count
            // is not 1
            persons[index]++;
            persons[index+1]++;
            // reduce odd count if the next person was also odd pre-distribution
            if (persons[index+1] % 2 == 0)
                odds -= 2;
            breads += 2;
        }
        // it's not possible to distribute so that every person
        // has an even number of breads when there's only one
        // person remaining that has an odd number of breads
        return odds == 1 ? "NO" : Integer.toString(breads);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt();
        }
        System.out.println(giveBreads(B));
    }
}
