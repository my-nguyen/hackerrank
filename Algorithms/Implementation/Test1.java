import java.util.*;

class Test1 {
    static void test(List<Integer> list) {
        System.out.println("new list");
        if (list.size() <= 1)
            System.out.println("small size, skipping");
        else {
            Iterator<Integer> it = list.iterator();
            it.next();
            while (it.hasNext()) {
                System.out.println("next: " + it.next());
                it.remove();
            }
        }
    }

    public static void main(String[] args) {
        /*
        List<Integer> list1 = Arrays.asList(1);
        List<Integer> list2 = Arrays.asList(10, 2);
        List<Integer> list3 = Arrays.asList(10, 3, 7);
        */
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(10);
        list3.add(3);
        list3.add(7);
        test(list1);
        test(list2);
        test(list3);
    }
}
