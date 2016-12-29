import java.util.*;

public class Solution {
    static class Player implements Comparable<Player> {
        int id;
        int points;

        Player(int id, int points) {
            this.id = id;
            this.points = points;
        }

        Player(String[] tokens) {
            this.id = Integer.parseInt(tokens[0]);
            int rushing = Integer.parseInt(tokens[1]);
            int passing = Integer.parseInt(tokens[2]);
            int td = Integer.parseInt(tokens[3]);
            int interception = Integer.parseInt(tokens[4]);
            this.points = rushing*2 + passing + td*6 - interception;
        }

        public int compareTo(Player other) {
            if (this.points < other.points)
                return -1;
            if (this.points > other.points)
                return 1;
            return other.id - this.id;
        }

        public String toString() {
            return id + "," + points;
        }
    }

    static class PlayerComparator implements Comparator {
        public int compare(Object one, Object two) {
            Player un = (Player)one;
            Player deux = (Player)two;
            return deux.compareTo(un);
        }
    }
    // static void
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Player> players = new PriorityQueue<>();
        int minPoints, maxPoints = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.equals("PRINT")) {
                Player[] list = new Player[players.size()];
                int j = 0;
                for (Player player : players) {
                    list[j] = player;
                    j++;
                }
                /*
                for (int i = 0; !players.isEmpty(); i++) {
                    list[i] = players.remove();
                }
                */
                Arrays.sort(list, new PlayerComparator());
                System.out.println("Leaders");
                for (int i = 0; i < list.length; i++)
                    System.out.println((i+1) + "," + list[i]);
            } else {
                String[] tokens = line.split(",");
                Player player = new Player(tokens);

                if (players.size() < 10) {
                    players.add(player);
                } else {
                    if (player.points > players.peek().points) {
                        players.remove();
                        players.add(player);
                    }
                }
            }
        }
    }
}
