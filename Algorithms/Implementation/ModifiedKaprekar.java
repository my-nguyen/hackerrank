import java.util.*;

public class Solution {
    static boolean isKaprekar(int number) {
        long squareNumber = (long)number * number;
        String squareString = Long.toString(squareNumber);
        int leftSize = squareString.length() / 2;
        int leftNumber;
        if (leftSize == 0)
            leftNumber = 0;
        else {
            String leftString = squareString.substring(0, leftSize);
            leftNumber = Integer.parseInt(leftString);
        }
        int rightSize = squareString.length() - leftSize;
        String rightString = squareString.substring(leftSize);
        // System.out.println("number: " + number + ", square: " + squareNumber + ", left: " + leftNumber + ", right: " + rightString);
        int rightNumber = Integer.parseInt(rightString);
        return leftNumber + rightNumber == number;
    }

    static List<Integer> getAllKaprekars(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (isKaprekar(i)) {
                // System.out.println(i + " is kaprekar");
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int low = in.nextInt();
        int high = in.nextInt();
        List<Integer> kaprekars = getAllKaprekars(low, high);
        if (kaprekars.size() == 0)
            System.out.println("INVALID RANGE");
        else {
            for (int kaprekar : kaprekars) {
                System.out.print(kaprekar + " ");
            }
            System.out.println();
        }
    }
}
