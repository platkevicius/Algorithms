package dp.topdown;

import java.util.Arrays;

public class CountingTowers {

    public static void main(String[] args) {
        CountingTowers countingTowers = new CountingTowers();
        int dp[][] = new int[6][8];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        int solution = countingTowers.solve(dp, 5, 2) + countingTowers.solve(dp, 5, 6);

        System.out.println(solution);
    }

    public int solve(int[][] dp, int n, int placed) {
        if (n == -1) return 1;
        if (dp[n][placed] != -1) return dp[n][placed];

        int ans;
        if (placed == 0 || placed == 5 || placed == 2 || placed == 3 || placed == 4) {
            ans = (solve(dp, n - 1, 0)
                  + solve(dp, n - 1, 1)
                  + solve(dp, n - 1, 3)
                  + solve(dp, n - 1, 4)
                  + solve(dp, n - 1, 5))%(1000000000+7);
        }
        else {
            ans = (solve(dp, n - 1, 7)
                  + solve(dp, n - 1, 6)
                  + solve(dp, n - 1, 2))%(1000000000+7);
        }

        return dp[n][placed] = ans;
    }
}
