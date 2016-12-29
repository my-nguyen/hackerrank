import java.util.*;

class CatsAndMouse {
    static String chase(int x, int y, int z) {
        int diffX = Math.abs(x - z);
        int diffY = Math.abs(y - z);
        if (diffX < diffY)
            return "Cat A";
        if (diffX > diffY)
            return "Cat B";
        return "Mouse C";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();
            String string = chase(x, y, z);
            System.out.println(string);
        }
    }
}
