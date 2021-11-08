package dp.topdown;

import java.util.Arrays;

public class CoinCombinationSorted {

    public static void main(String[] args) {
        CoinCombinationSorted coinCombinationSorted = new CoinCombinationSorted();

        int[][] dp = new int[3][10];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        System.out.println(coinCombinationSorted.solve(new int[]{2, 3, 5}, 9, 2, dp));
    }

    public int solve(int[] coins, int n, int m, int[][] dp) {
        if (n == 0) return 1;
        if (m == -1) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        if (coins[m] <= n) {
            return solve(coins, n - coins[m], m, dp) + solve(coins, n, m-1, dp);
        } else {
            return solve(coins, n, m-1, dp);
        }
    }

}
