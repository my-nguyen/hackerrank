import java.util.*;

class MusicStreet {
    private static boolean goodInterval(int interval, int minHours, int maxHours) {
        boolean result = interval >= minHours && interval <= maxHours;
        System.out.println("interval: " + interval + ", good: " + result);
        return result;
    }

    private static int process(List<Integer> borders, int mileCount, int minHours, int maxHours) {
        for (int i = maxHours; i >= minHours; i--) {
            for (int j = 0; j < borders.size()-1; j++) {
                int sum = i;
                System.out.println("i: " + i);
                boolean goodInterval = true;
                for (int k = j; k < borders.size()-1 && goodInterval && sum < mileCount; k++) {
                    int interval = borders.get(k+1) - borders.get(k);
                    if (goodInterval(interval, minHours, maxHours))
                        sum += interval;
                    else
                        goodInterval = false;
                }
                if (goodInterval) {
                    System.out.println("sum: " + sum + ", mileCount: " + mileCount);
                    if (sum == mileCount || goodInterval(mileCount-sum, minHours, maxHours))
                        return borders.get(j) - i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int borderCount = scanner.nextInt();
        List<Integer> borders = new ArrayList<>();
        for (int i = 0; i < borderCount; i++)
            borders.add(scanner.nextInt());
        int mileCount = scanner.nextInt();
        int minHours = scanner.nextInt();
        int maxHours = scanner.nextInt();

        int start = process(borders, mileCount, minHours, maxHours);
        System.out.println(start);
    }
}
