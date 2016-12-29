import java.util.*;

class EmmasSupercomputer {
    static class Location {
        int row;
        int column;

        public Location(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static class Plus {
        Location center;
        int span;

        public Plus(Location location, int span) {
            this.center = location;
            this.span = span;
        }

        public int area() {
            return 1 + span*4;
        }
    }

    static class Cell {
        boolean good;
        boolean used;

        public Cell(boolean good) {
            this.good = good;
        }

        public boolean valid() {
            return good && !used;
        }

        public void negate() {
            good = !good;
            used = !used;
        }
    }

    static class Grid {
        private Cell[][] cells;

        public Grid(List<String> lines) {
            int rowCount = lines.size();
            int columnCount = lines.get(0).length();
            cells = new Cell[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    boolean good = lines.get(i).charAt(j) == 'G';
                    cells[i][j] = new Cell(good);
                }
            }
        }

        public int process() {
            List<Integer> pluses = collectPluses();
            int product = multiply(pluses);
            return product;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    char c = cells[i][j].good ? '*' : ' ';
                    builder.append(c);
                }
                builder.append('\n');
            }
            return builder.toString();
        }

        private static int multiply(List<Integer> pluses) {
            int result = 1;
            for (int plus : pluses)
                result *= plus;
            return result;
        }

        private int spanUp(Location location) {
            int count = 1;
            while (location.row-count >= 0 &&
                   cells[location.row-count][location.column].valid())
                count++;
            return count-1;
        }

        private int spanRight(Location location) {
            int count = 1;
            while (location.column+count < cells[location.row].length &&
                   cells[location.row][location.column+count].valid())
                count++;
            return count-1;
        }

        private int spanDown(Location location) {
            int count = 1;
            while (location.row+count < cells.length &&
                   cells[location.row+count][location.column].valid())
                count++;
            return count-1;
        }

        private int spanLeft(Location location) {
            int count = 1;
            while (location.column-count >= 0 &&
                   cells[location.row][location.column-count].valid())
                count++;
            return count-1;
        }

        private int shortestSpan(Location location) {
            int up = spanUp(location);
            int min = up;
            int right = spanRight(location);
            min = Math.min(min, right);
            int down = spanDown(location);
            min = Math.min(min, down);
            int left = spanLeft(location);
            min = Math.min(min, left);
            System.out.println("i: " + location.row + ", j: " + location.column + ", up: " + up + ", right: " + right + ", down: " + down + ", left: " + left + ", min: " + min);
            return min;
        }

        private void usePlus(Plus plus) {
            cells[plus.center.row][plus.center.column].negate();
            for (int i = 1; i <= plus.span; i++) {
                cells[plus.center.row-i][plus.center.column].negate();
                cells[plus.center.row+i][plus.center.column].negate();
            }
            for (int j = 1; j <= plus.span; j++) {
                cells[plus.center.row][plus.center.column-j].negate();
                cells[plus.center.row][plus.center.column+j].negate();
            }
        }

        private List<Integer> collectPluses() {
            List<Integer> areas = new ArrayList<>();
            for (int i = 1; i < cells.length-1; i++) {
                for (int j = 1; j < cells[i].length-1; j++) {
                    if (cells[i][j].good) {
                        Location location = new Location(i, j);
                        int span = shortestSpan(location);
                        if (span > 0) {
                            Plus plus = new Plus(location, span);
                            usePlus(plus);
                            System.out.print(this);
                            areas.add(plus.area());
                            System.out.println("area: " + plus.area());
                        }
                    }
                }
            }
            return areas;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            String line = in.next();
            lines.add(line);
        }
        Grid grid = new Grid(lines);
        System.out.print(grid);

        int product = grid.process();
        System.out.println(product);
    }
}
