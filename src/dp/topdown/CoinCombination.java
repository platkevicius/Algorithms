package dp.topdown;

public class CoinCombination {

    public static void main(String[] args) {
        CoinCombination coinCombination = new CoinCombination();

        System.out.println(coinCombination.solve(new int[]{2, 3, 5}, 9, new int[10]));
    }

    public int solve(int[] coins, int n, int[] dp) {
        if (n == 0) return 1;
        if (dp[n] != 0) return dp[n];

        int ans = 0;
        for (int i = 0; i < coins.length; i++) {
            if (n - coins[i] >= 0)
                ans += solve(coins, n - coins[i], dp);
        }

        dp[n] = ans;
        return dp[n];
    }
}
