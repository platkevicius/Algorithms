package dp.topdown;

import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int[][] dp = new int[3][51];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        System.out.println(knapsack.solve(dp, 50, 2, weight, value));
    }

    public int solve(int[][] dp, int n, int m, int[] weights, int[] value) {
        if (n == 0 || m == -1) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        if (n - weights[m] >= 0)
            return dp[m][n] = Math.max(solve(dp, n, m - 1, weights, value),
                                       solve(dp, n - weights[m], m - 1, weights, value) + value[m]);
        else
            return solve(dp, n, m-1, weights, value);
    }
}
