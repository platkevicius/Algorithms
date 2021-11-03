package dp.topdown;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{20, 30, 15, 10, 1, 2, 3, 4, 5},30));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int min = coinChange(coins, amount, dp);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != Integer.MAX_VALUE) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int val = coinChange(coins, amount - coins[i], dp);

            if (val != Integer.MAX_VALUE) {
                min = Math.min(min, val + 1);
            }
        }

        dp[amount] = min;
        return min;
    }

}
