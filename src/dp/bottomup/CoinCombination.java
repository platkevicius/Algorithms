package dp.bottomup;

public class CoinCombination {

    public static void main(String[] args) {
        System.out.println(solve(9, new int[]{2, 3, 5}));
    }

    private static int solve(int n, int[] coins) {
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] += dp[i-coin];
                }
            }
        }

        return dp[n];
    }

}
