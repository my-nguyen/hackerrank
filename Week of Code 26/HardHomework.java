import java.util.*;

class HardHomework {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double maxSin = 0;
        for (int x = 1; x < n-1; x++) {
            for (int y = 1; y < n-1; y++) {
                for (int z = 1; z < n-1; z++) {
                    if (x + y + z == n) {
                        double sin = Math.sin(x) + Math.sin(y) + Math.sin(z);
                        maxSin = Math.max(maxSin, sin);
                    }
                }
            }
        }
        System.out.printf("%.9f\n", maxSin);
    }
}
