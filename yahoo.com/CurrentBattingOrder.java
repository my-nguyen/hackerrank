import java.util.*;

public class CurrentBattingOrder {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        Map<Integer, Map<Integer, String[]>> game = new LinkedHashMap<>();
        while (in.hasNext()) {
            String line = in.nextLine();
            String[] tokens = line.split(",");
            int teamId = Integer.parseInt(tokens[1]);
            Map<Integer, String[]> lineup = game.get(teamId);
            if (lineup == null) {
                lineup = new LinkedHashMap<>();
                game.put(teamId, lineup);
            }
            String[] copy = new String[tokens.length-1];
            System.arraycopy(tokens, 0, copy, 0, tokens.length-1);
            int battlingOrder = Integer.parseInt(tokens[tokens.length-2]);
            lineup.put(battlingOrder, tokens);
        }
        for (Map.Entry<Integer, Map<Integer, String[]>> entry : game.entrySet()) {
            Map<Integer, String[]> lineup = entry.getValue();
            for (Map.Entry<Integer, String[]> line : lineup.entrySet()) {
                String[] tokens = line.getValue();
                System.out.print(tokens[0]);
                for (int i = 1; i < tokens.length-1; i++) {
                    System.out.print("," + tokens[i]);
                }
                System.out.println();
            }
        }
        /*
        String line = in.nextLine();
        String[] tokens = line.split(",");
        String teamId = tokens[1];
        int battlingOrder = Integer.parseInt(tokens[tokens.length-2]);
        Map<Integer, String[]> lineup = new HashMap();
        lineup.put(battlingOrder, tokens);
        while (in.hasNext()) {
            String string = in.nextLine();
            String[] game = line.split(",");
            if (tokens[1].equals(teamId)) {
                lineup.put(order, game);
            } else {
                teamId = tokens[1];
            }
        }
        */
    }
}
