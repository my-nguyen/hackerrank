import java.util.*;

class FlatlandSpaceStations {
    static int findNearest(int id, boolean[] nearest) {
        for (int i = 0; true; i++) {
            // both ends are out of bounds
            if (id-i < 0 && id+i >= nearest.length)
                return -1;
            // only the lower end is out of bounds
            if (id-i < 0) {
                if (nearest[id+i])
                    return i;
            // only the upper end is out of bounds
            } else if (id+i >= nearest.length) {
                if (nearest[id-i])
                    return i;
            // both ends are within bounds
            } else {
                if (nearest[id+i] || nearest[id-i])
                    return i;
            }
        }
    }

    static int maxDistance(int cityCount, int[] stations) {
        boolean[] nearest = new boolean[cityCount];
        for (int i = 0; i < stations.length; i++)
            nearest[stations[i]] = true;

        int max = 0;
        for (int i = 0; i < cityCount; i++) {
            int distance = findNearest(i, nearest);
            // System.out.println("i: " + i + ", distance: " + distance);
            max = Math.max(max, distance);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cityCount = in.nextInt();
        int stationCount = in.nextInt();
        int stations[] = new int[stationCount];
        for(int i = 0; i < stationCount; i++){
            stations[i] = in.nextInt();
            // System.out.println("station at " + i + ": " + stations[i]);
        }

        int distance = maxDistance(cityCount, stations);
        System.out.println(distance);
    }
}
