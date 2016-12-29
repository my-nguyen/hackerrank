class BitManipulation {
    static int lonelyInteger(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer value = map.get(array[i]);
            if (value == null) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], value+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] list = new int[count]
        for (int i = 0; i < count; i++) {
            list[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(array));
    }
}
