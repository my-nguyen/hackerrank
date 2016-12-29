import java.util.*;

class SpecialMultiple {
    static List<Long> values = null;

    // pre-fill an array of Long with all the possible numbers with only 0 and 9
    // in them. since there's only 2 possible digits (0 and 9), I model my
    // calculation after binary numbers
    static void precalculate() {
        if (values == null) {
            values = new ArrayList<>();
            // 8192 (2^13) is large enough to cover all the hackerrank test case
            for (int i = 1; i < 8192; i++) {
                // convert the decimal number to its binary string equivalence
                String binary = Integer.toBinaryString(i);
                // replace all '1's with '9's in the binary string
                String nines = binary.replace('1', '9');
                // convert the string back to a long number
                long number = Long.parseLong(nines);
                values.add(number);
            }
        }
    }

    static long calculate(int number) {
        precalculate();
        for (long value : values) {
            if (value % number == 0)
                return value;
        }
        return -1L;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();
            System.out.println(calculate(number));
        }
    }
}
