import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();
            String pattern = "nba\\.p\\.\\d+";
            Pattern r = Pattern.compile(pattern);
            Matcher matcher = r.matcher(line);
            for (boolean first = true; matcher.find(); first = false) {
                if (!first)
                    System.out.print(",");
                System.out.print(matcher.group());
            }
            System.out.println();
        }
    }
}
