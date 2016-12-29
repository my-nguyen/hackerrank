import java.util.*;

class MarsExploration {
    static String buildMessage(int count) {
        StringBuilder builder = new StringBuilder();
        final String SOS = "SOS";
        for (int i = 0; i < count; i++)
            builder.append(SOS);
        return builder.toString();
    }

    static int countAlterations(String message) {
        int countMessages = message.length() / 3;
        String modelMessage = buildMessage(countMessages);
        int alterations = 0;
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != modelMessage.charAt(i))
                alterations++;
        }
        return alterations;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.next();
        int count = countAlterations(message);
        System.out.println(count);
    }
}
