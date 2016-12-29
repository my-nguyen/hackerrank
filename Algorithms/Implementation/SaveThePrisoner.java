import java.util.*;

public class SaveThePrisoner {
    private static int poisonedId(int prisoners, int sweets, int startId) {
        return (sweets + startId - 2) % prisoners + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int i = 0; i < cases; i++) {
            int prisoners = in.nextInt();
            int sweets = in.nextInt();
            int startId = in.nextInt();
            System.out.println(poisonedId(prisoners, sweets, startId));
        }
    }
}
