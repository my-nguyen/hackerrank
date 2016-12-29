class GLMCoinChange {
    public static long makeChange(int[] coins, int money) {
        return makeChange(coins, money, 0, new HashMap<>());
    }

    public static long makeChange(int[] coins, int money, int index, Map<String, Long> memo) {
        if (money == 0)
            return 1;
        if (index >= coins.length)
            return 0;

        String key = money + "-" + index;
        if (memo.contains(key))
            return memo.get(key);

        int amountWithCoin = 0;
        long ways = 0;
        while (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways += makeChange(coins, remaining, index+1, memo);
            amountWithCoin += coins[index];
        }
        memo.put(key, ways);
        return ways;
    }
}
