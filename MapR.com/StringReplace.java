class StringReplacement {
    static String stringReplace(String source, String match, String replace) {
        if (match.isEmpty())
            return source;

        StringBuilder builder = new StringBuilder();
        int begin = 0;
        int end = 0;
        while ((end = source.substring(begin).indexOf(match)) != -1) {
            builder.append(source.substring(begin, begin+end));
            builder.append(replace);
            System.out.println("begin: " + begin + ", end: " + end + ", match: " + match.length());
            System.out.println("builder so far: " + builder);
            begin += end + match.length();
        }
        System.out.println("begin: " + begin + ", end: " + end + ", match: " + match.length());
        if (begin < source.length()) {
            builder.append(source.substring(begin));
        }

        return builder.toString();
    }
}
