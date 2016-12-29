import java.util.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        int infoCount = 0;
        int warnCount = 0;
        Set<String> snValues = new HashSet<>();
        Set<String> siValues = new HashSet<>();
        int ssMax = Integer.MIN_VALUE;
        while (in.hasNext()) {
            String date = in.nextLine();
            String info = in.nextLine();
            if (info.startsWith("INFO")) {
                infoCount++;
                String[] tokens = info.substring(7).split(",");
                for (String token : tokens) {
                    String[] keyValue = token.split("[ :]");
                    for (int i = 0; i < keyValue.length; i++) {
                        if (!keyValue[i].isEmpty()) {
                            if (keyValue[i].equals("\"sn\"")) {
                                String snValue = keyValue[i+2].substring(1, keyValue[i+2].length()-1);
                                snValues.add(snValue);
                            } else if (keyValue[i].equals("\"si\"")) {
                                String siValue = keyValue[i+2].substring(1, keyValue[i+2].length()-1);
                                siValues.add(siValue);
                            } else if (keyValue[i].startsWith("\"ss\"")) {
                                int ss = Integer.parseInt(keyValue[i+2]);
                                ssMax = Math.max(ss, ssMax);
                            }
                        }
                    }
                }
            } else
                warnCount++;
        }
        
        System.out.println(infoCount);
        System.out.println(warnCount);
        System.out.println(snValues.size());
        System.out.println(siValues.size());
        System.out.println(ssMax);
    }
}
