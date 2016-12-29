class Test1 {
    public static void main(String[] args) {
        if (args.length != 0) {
            String word = args[0];
            for (char letter : word.toCharArray()) {
                int letterA = Character.getNumericValue('a');
                int value = Character.getNumericValue(letter) - letterA;
                System.out.println("letter: " + letter + ", number: " + (int)letter + ", value: " + value);
            }
        }
    }
}
