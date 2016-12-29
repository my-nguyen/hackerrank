import java.util.*;

class IsFibo {
    static class Fibo {
        List<Long> fibos;

        Fibo() {
            fibos = new ArrayList<>();
            fibos.add(0L);
            fibos.add(1L);
            long fibo = 0L;
            for (int i = 2; fibo < 10000000000L; i++) {
                fibo = fibos.get(i-1) + fibos.get(i-2);
                fibos.add(fibo);
            }
            // System.out.println("size: " + fibos.size());
        }

        boolean contains(long number) {
            return Collections.binarySearch(fibos, number) >= 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fibo fibo = new Fibo();
        int count = scanner.nextInt();
        final String isFibo = "IsFibo";
        final String isNotFibo = "IsNotFibo";
        for (int i = 0; i < count; i++) {
            long number = scanner.nextLong();
            System.out.println(fibo.contains(number) ? isFibo : isNotFibo);
        }
    }
}
