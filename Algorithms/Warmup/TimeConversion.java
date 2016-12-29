import java.util.*;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        boolean isMorning = time.charAt(time.length()-2) == 'A';
        StringBuilder builder = new StringBuilder();
        String hour = time.substring(0, 2);
        if (isMorning) {
            builder.append(hour.equals("12") ? "00" : hour);
        } else {
            builder.append(hour.equals("12") ? hour : (Integer.parseInt(hour) + 12));
        }
        builder.append(time.substring(2, time.length()-2));
        System.out.println(builder);
    }
}
