import java.util.*;

class MyList {
    int[] list;
    int size;

    MyList(int size) {
        list = new int[size];
        this.size = 0;
    }

    void shift(int index) {
        for (int i = size; i > index; i--)
            list[i] = list[i-1];
        size++;
    }

    void add(int number) {
        int i = 0;
        while (i < size && number < list[i]) {
            i++;
        }
        shift(i);
        list[i] = number;
    }

    int get(int index) {
        return list[index];
    }

    int size() {
        return size;
    }
}

class HeapsMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // implementation with List<Integer> times out on tests # 3, 4, 5, 6, 7
        // 8, and 9. using my own MyList class instead passes all the tests.
        // List<Integer> list = new ArrayList<>();
        MyList list = new MyList(n);
        for(int i=0; i < n; i++){
            list.add(in.nextInt());
            // Collections.sort(list);
            float median;
            int middle = list.size() / 2;
            if (list.size() % 2 == 0) {
                median = (list.get(middle-1) + list.get(middle)) / 2.0F;
            } else
                median = list.get(middle);
            System.out.println(median);
        }
    }
}
