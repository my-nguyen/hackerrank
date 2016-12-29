import java.util.*;

class Test1 {
    static class Rank implements Comparable<Rank> {
        int number;
        int index;
        int rank;

        public Rank(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int compareTo(Rank other) {
            if (this.number == other.number)
                return 0;
            if (this.number > other.number)
                return 1;
            return -1;
        }

        public String toString() {
            return number + ":" + index + ":" + rank;
        }
    }

    public static void main(String[] args) {
        List<Rank> ranks = new ArrayList<>();
        int[] numbers = { 1, 200, 50, 80, 1000, 60 };
        for (int i = 0; i < numbers.length; i++) {
            Rank rank = new Rank(numbers[i], i);
            ranks.add(rank);
        }

        Collections.sort(ranks);
        for (int i = 0; i < ranks.size(); i++) {
            Rank rank = ranks.get(i);
            rank.rank = ranks.size() - 1 - i;
        }

        for (Rank rank : ranks)
            System.out.println(rank);
    }
}
