package dp.bottomup;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(solve(30, new int[]{20, 15, 10, 1, 2, 3, 4, 5}));
    }

    private static int solve(int n, int[] coins) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i < n; i++) {
            for (int coin : coins) {
                if (i + 1 - coin == 0) {
                    dp[i] = 1;
                    break;
                }

                if (i - coin >= 1) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        return dp[n-1];
    }

}
