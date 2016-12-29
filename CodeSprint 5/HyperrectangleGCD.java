class HyperrectangleGCD {
    static int gcd(int one, int two) {
        while (one != 0) {
            int tmp = one;
            one = two % one;
            two = tmp;
        }
        return two;
    }

    static int calculate(int[] lengths) {
        int dimension = lengths.length;
        if (dimension == 2) {
            for ()
        }
    }

    public static void main(String[] args]) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int dimension = scanner.nextInt();
            int[] lengths = new int[dimension];
            for (int j = 0; j < dimension; j++) {
                lengths[j] = scanner.nextInt();
            }
        }
    }
}
