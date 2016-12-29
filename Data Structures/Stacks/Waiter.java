import java.util.*;

public class Solution {
    static class Primes {
        // list of prime numbers
        List<Integer> numbers;

        Primes(int size) {
            BitSet field = new BitSet(size);
            // initialize all bits to ON
            field.set(0, size);

            // numbers 0 and 1 are not primes
            field.clear(0);
            field.clear(1);

            // start with 2, the very first prime number
            numbers = new ArrayList<>();
            for (int i = 2; i < size; i++) {
                // test whether bit at i is ON
                if (field.get(i)) {
                    // save the prime number
                    numbers.add(i);
                    int multiple = 2;
                    while (i*multiple < size) {
                        // all multiples of a prime numbers (2p, 3p, 4p, etc) are
                        // not primes. So turn off bit at (i*multiple)th position.
                        field.clear(i*multiple);
                        multiple += 1;
                    }
                }
            }
        }

        int get(int index) {
            return numbers.get(index);
        }
    }

    static List<Integer> process(Stack<Integer> aPile, int iterations) {
        // ratio of prime N to natural number is NlogN
        // calculate the log base 2
        double log = Math.log(iterations) / Math.log(2);
        // add 10 extra natural numbers just in case
        int size = (int)(iterations * log) + 10;
        Primes primes = new Primes(size);

        // list of all B piles
        List<Stack<Integer>> allBPiles = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            int prime = primes.get(i);
            Stack<Integer> pile = new Stack<>();
            Stack<Integer> bPile = new Stack<>();
            while (!aPile.empty()) {
                int plate = aPile.pop();
                if (plate % prime == 0)
                    // transfer plate to the B pile
                    bPile.add(plate);
                else
                    // transfer to the next A pile
                    pile.push(plate);
            }
            if (!bPile.empty())
                allBPiles.add(bPile);
            // move on to the next A pile
            aPile = pile;
        }

        // collect all B piles
        List<Integer> result = new ArrayList<>();
        for (Stack<Integer> bPile : allBPiles) {
            while (!bPile.empty()) {
                result.add(bPile.pop());
            }
        }
        // collect the remaining A pile
        while (!aPile.empty()) {
            result.add(aPile.pop());
        }
        return result;
    }

    static void print(List<Integer> list) {
        for (int number : list)
            System.out.println(number);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int plates = in.nextInt();
        int iterations = in.nextInt();
        Stack<Integer> pile = new Stack<>();
        for (int i = 0; i < plates; i++)
            pile.add(in.nextInt());

        List<Integer> list = process(pile, iterations);
        print(list);
    }
}
