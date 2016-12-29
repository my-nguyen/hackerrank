import java.util.*;

class GamingArray {
    static class Rank implements Comparable<Rank> {
        int number; // the original array element
        int index;  // the original index of array element
        int rank;   // ranking (in descending order) of array element

        Rank(int number, int index) {
            this.number = number;
            this.index = index;
        }

        // to sort a List<Rank> in descending order
        public int compareTo(Rank other) {
            if (other.number == this.number)
                return 0;
            if (other.number > this.number)
                return 1;
            return -1;
        }

        public String toString() {
            return number + ":" + index + ":" + rank;
        }
    }

    static class Game {
        List<Rank> ranks;

        public Game(int[] array) {
            ranks = new ArrayList<>();
            // convert array of ints to a list of Ranks
            for (int i = 0; i < array.length; i++)
                ranks.add(new Rank(array[i], i));
            // sort List<Rank> in descending order
            Collections.sort(ranks);
            // assign the ranking of each Rank in the sorted list
            for (int i = 0; i < ranks.size(); i++) {
                Rank rank = ranks.get(i);
                rank.rank = ranks.size() - 1 - i;
            }
            // System.out.println(this);
        }

        // return the next rank that fits in the current size of List<Rank>
        private int nextRank(int size, int rank) {
            while (ranks.get(rank).index >= size) {
                rank++;
            }
            return rank;
        }

        public String play() {
            int size = ranks.size();
            int rank = 0;
            int turn = 0;
            while (size > 0) {
                // obtain the rank that fits within the current size
                rank = nextRank(size, rank);
                // adjust the size
                size = ranks.get(rank).index;
                // try the next rank
                rank++;
                // next player's turn
                turn++;
            }

            return player(turn);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < ranks.size(); i++) {
                builder.append(ranks.get(i).toString());
                builder.append("\n");
            }
            return builder.toString();
        }

        private String player(int turn) {
            final String[] names = { "ANDY", "BOB" };
            int index = turn % 2;
            return names[index];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int gameCount = in.nextInt();
        for (int i = 0; i < gameCount; i++) {
            int arrayCount = in.nextInt();
            int[] array = new int[arrayCount];
            for (int j = 0; j < arrayCount; j++) {
                array[j] = in.nextInt();
            }
            Game game = new Game(array);
            String name = game.play();
            System.out.println(name);
        }
    }
}
