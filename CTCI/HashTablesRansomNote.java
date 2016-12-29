import java.util.*;

class HashTablesRansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public HashTablesRansomNote(String magazine, String note) {
        magazineMap = initialize(magazine);
        noteMap = initialize(note);
        /*
        for (String word : magazine.split(" ")) {
            Integer count = magazineMap.get(word);
            if (count == null)
                magazineMap.put(word, 1);
            else
                magazineMap.put(word, count+1);
        }

        noteMap = new HashMap<>();
        for (String word : note.split(" ")) {
            Integer count = noteMap.get(word);
            if (count == null)
                noteMap.put(word, 1);
            else
                noteMap.put(word, count+1);
        }
        */
    }

    public boolean solve() {
        for (Map.Entry<String, Integer> entry : noteMap.entrySet()) {
            String noteKey = entry.getKey();
            Integer noteValue = entry.getValue();
            Integer magazineValue = magazineMap.get(noteKey);
            if (magazineValue == null || magazineValue < noteValue)
                return false;
        }
        return true;
    }

    private static Map<String, Integer> initialize(String string) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : string.split(" ")) {
            Integer count = map.get(word);
            if (count == null)
                map.put(word, 1);
            else
                map.put(word, count+1);
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        HashTablesRansomNote s = new HashTablesRansomNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
    }
}
