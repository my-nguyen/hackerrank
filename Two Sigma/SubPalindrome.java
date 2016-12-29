static int palindrome(String string) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i <= string.length(); i++) {
            for (int j = i, k = i; j >= 0 && k < string.length() && string.charAt(j) == string.charAt(k); j--, k++) {
                String sub = string.substring(j, k+1);
                int pre = palindromes.size();
                palindromes.add(sub);
                System.out.println("adding pal: " + sub + ", pre: " + pre + ", post: " + palindromes.size());
            }
            for (int j = i, k = i+1; j >= 0 && k < string.length() && string.charAt(j) == string.charAt(k); j--, k++) {
                String sub = string.substring(j, k+1);
                int pre = palindromes.size();
                palindromes.add(sub);
                System.out.println("adding pal: " + sub + ", pre: " + pre + ", post: " + palindromes.size());
            }
        }
        return palindromes.size();
    }
