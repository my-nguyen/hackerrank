import java.util.*;

class SatisfactoryPairs {
    static class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a + "-" + b;
        }
    }

    public static List<Pair> process(int n) {
        List<Pair> pairs = new ArrayList<>();
        for (int a = 1; a < n-1; a++) {
            for (int b = a+1; b < n; b++) {
                for (int x = 1; x < n-1; x++) {
                    for (int y = 1; y < n; y++) {
                        int calc = x*a + y*b;
                        // System.out.println("a: " + a + ", b: " + b + ", x: " + x + ", y: " + y);
                        if (calc > n)
                            break;
                        if (calc == n) {
                            Pair pair = new Pair(a, b);
                            pairs.add(pair);
                            // System.out.println("add pair " + pair);
                            break;
                        }
                    }
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Pair> pairs = process(n);
        System.out.println(pairs.size());
    }
}
