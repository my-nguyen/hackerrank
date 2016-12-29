import java.math.*;

class MyFactorial {
    static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            int number = Integer.parseInt(args[0]);
            System.out.println("factorial of " + number + ": " + factorial(number));
        }
    }
}
