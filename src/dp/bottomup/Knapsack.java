package dp.bottomup;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};

        System.out.println(solve(50, 2, weight, value));
    }

    private static int solve(int n, int m, int[] weights, int[] value) {
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j - weights[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

}
