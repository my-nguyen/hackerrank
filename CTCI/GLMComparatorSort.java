class Player {
    int score;
    String name;
}

// sort by score in descending order (so the higher scoring person appears first)
// if multiple players have the same score, then sort by name in ascending order
class Checker implements Comparator<Player> {
    // x.compareTo(y):
    // negative value if x < y (x should appear first)
    // zero if x == y
    // positive value if x > y (x should appear second)
    public int compare(Player a, Player b) {
        if (a.score == b.score) {
            return a.name.compareTo(b.name);
        } else {
            return b.score - a.score;
        }
    }
}
