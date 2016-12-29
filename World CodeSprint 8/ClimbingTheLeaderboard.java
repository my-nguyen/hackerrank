import java.util.*;

public class Solution {
    static Map<Integer, Integer> ranks;

    static void setRanks(List<Integer> scores) {
        ranks = new HashMap<>();
        int i = 0;
        int rank = 1;
        while (i < scores.size()) {
            int score = scores.get(i);
            ranks.put(score, rank);
            i++;
            while (i < scores.size() && scores.get(i) == score)
                i++;
            rank++;
        }
    }

    static int getRank(List<Integer> scores, int score) {
        final Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        };
        int index = Collections.binarySearch(scores, score, comparator);
        int rank;
        if (index >= 0)
            rank = ranks.get(scores.get(index));
        else {
            index = -(index + 1);
            if (index == scores.size())
                rank = ranks.size() + 1;
            else
                rank = ranks.get(scores.get(index));
        }
        return rank;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < n; i++)
            scores.add(in.nextInt());
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }

        setRanks(scores);
        for (int score : alice) {
            System.out.println(getRank(scores, score));
        }
    }
}
