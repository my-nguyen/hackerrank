import java.util.*;

class IceCream implements Comparable {
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
        this.flavor = flavor;
        this.index = index;
    }

    @Override
    public int compareTo(Object o) {
        return this.flavor - ((IceCream)o).flavor;
    }

    @Override
    public boolean equals(Object o){
        return this.flavor == ((IceCream)o).flavor;
    }
}

// implementation that uses the required user-defined IceCream class and the
// binarySearch method
public class BinarySearchIceCream {
    public static int binarySearch(int first, int last, IceCream[] arr, int target) {
        while (first <= last) {
            int middle = (first + last) / 2;
            if (arr[middle].flavor < target)
                first = middle + 1;
            else if (arr[middle].flavor > target)
                last = middle - 1;
            else
                return arr[middle].index;
        }
        return -1;
    }

    public static void main(String[] args) {
        int t;
        int n, m;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {
            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];
            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);
            for(int i = 0; i < n-1; i++) {
                int target = m - arr[i].flavor;
                if (target >= arr[i].flavor) {
                    int index = binarySearch(i+1, n-1, arr, target);
                    if (index != -1) {
                        System.out.println(Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;
                    }
                }
            }
        }
    }
}
