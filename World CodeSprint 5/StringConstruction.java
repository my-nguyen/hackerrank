import java.util.*;

class StringConstruction {
    static int copy(String string) {
        Set<Character> chars = new HashSet<>();
        for (char c : string.toCharArray()) {
            chars.add(c);
        }
        return chars.size();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int strings = in.nextInt();
        for(int i = 0; i < strings; i++){
            String string = in.next();
            int count = copy(string);
            System.out.println(count);
        }
    }
}
