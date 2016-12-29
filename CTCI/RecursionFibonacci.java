public class RecursionFibonacci {
    static int[] memo;

    public static int fibonacci(int n) {
        if (n == 0 || n == 1)
            return n;
        if (memo[n] == 0)
            memo[n] = fibonacci(n-1) + fibonacci(n-2);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        memo = new int[n + 1];
        System.out.println(fibonacci(n));
    }
}
