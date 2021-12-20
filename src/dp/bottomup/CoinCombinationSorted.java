package dp.bottomup;

public class CoinCombinationSorted {

    public static void main(String[] args) {
        System.out.println(solve(9, new int[]{2, 3, 5}));
    }

    private static int solve(int n, int[] coins) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i < n; i++) {

                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[n - 1];
    }
}
