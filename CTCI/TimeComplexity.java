import java.util.*;

class TimeComplexity {
    static class Prime {
        Set<Integer> indices;

        Prime() {
            BitSet primes = fillPrimes();
            indices = savePrimeIndices(primes);
        }

        private BitSet fillPrimes() {
            final int MAX_PRIME = 200;
            BitSet primes = new BitSet(MAX_PRIME);
            primes.set(0, MAX_PRIME);

            for (int i = 2; i < MAX_PRIME; i++) {
                // i is a prime number
                if (primes.get(i)) {
                    // all multiples of i are not prime
                    for (int j = 2; i*j < MAX_PRIME; j++) {
                        primes.clear(i*j);
                    }
                }
            }
            return primes;
        }

        private Set<Integer> savePrimeIndices(BitSet primes) {
            indices = new HashSet<>();
            for (int i = 2; i < primes.size(); i++) {
                if (primes.get(i)) {
                    indices.add(i);
                }
            }
            return indices;
        }

        // the advanced solution that uses sieve of Eratosthenes but it's too
        // slow for large numbers, since it has to build a prime table first
        boolean isPrime2(int number) {
            return indices.contains(number);
        }

        // the naive solution, yet it's extremely fast when dealing with numbers
        // like 1000000007, 100000003, 1000003
        boolean isPrime(int number) {
            int sqrt = (int)Math.sqrt(number);
            for (int i = 2; i < sqrt; i++) {
                if (number % i == 0)
                    return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            Iterator<Integer> it = indices.iterator();
            for (int i = 0; it.hasNext(); i++) {
                builder.append(it.next()).append(" ");
                if (i != 0 && i % 20 == 0)
                    builder.append("\n");
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Prime prime = new Prime();
        for(int i = 0; i < count; i++){
            int n = in.nextInt();
            // System.out.println(prime);
            System.out.println(prime.isPrime(n) ? "Prime" : "Not prime");
        }
    }
}
