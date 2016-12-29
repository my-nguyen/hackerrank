public class Solution {
    static List<Integer> convert(String string) {
        List<Integer> numbers = new ArrayList<>();
        String[] tokens = string.split(" ");
        for (String token : tokens) {
            numbers.add(Integer.parseInt(token));
        }
        return numbers;
    }

    static String shift(String input, List<Integer> command) {
        int low = command.get(1);
        int high = command.get(2);
        StringBuilder builder = new StringBuilder(input.substring(0, low));
        for (int i = low; i <= high; i++) {
            char c = input.charAt(i);
            int offset = c - 'a';
            offset = (offset + command.get(3)) % 26;
            c = (char)('a' + offset);
            builder.append(c);
        }
        builder.append(input.substring(high, input.length()));
        return builder.toString();
    }

    static boolean isPalindrome(String string) {
        boolean result = string.equals(new StringBuilder(string).reverse().toString());
        System.out.println("string: " + string + ", is pal? " + result);
        return result;
    }

    static int countPalindromes(String string, List<Integer> command) {
        int low = command.get(1);
        int high = command.get(2);
        int count = high - low + 1;
        for (int i = low; i < high-1; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(string.charAt(i));
            for (int j = i+1; j < high; j++) {
                builder.append(string.charAt(j));
                if (isPalindrome(builder.toString())) {
                    count++;
                }
                else
                    ; // builder.setLength(builder.length() - 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String r = in.nextLine();
        String[] tokens = r.split(" ");
        int n = Integer.parseInt(tokens[0]);
        int q = Integer.parseInt(tokens[1]);
        String s = in.nextLine();
        for(int a0 = 0; a0 < q; a0++){
            // your code goes here
            String query = in.nextLine();
            List<Integer> command = convert(query);
            if (command.get(0) == 1)
                s = shift(s, command);
            else {
                System.out.println(countPalindromes(s, command));
            }
        }
    }
}
