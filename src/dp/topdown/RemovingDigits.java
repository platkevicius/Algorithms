package dp.topdown;

import java.util.Arrays;

public class RemovingDigits {

    public static void main(String[] args) {
        RemovingDigits removingDigits = new RemovingDigits();
        int[] dp = new int[28];
        Arrays.fill(dp, -1);
        System.out.println(removingDigits.solve(27, dp));
    }

    public int solve(int n, int[] dp) {
        if (n == 0) return 0;
        if (dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;

        int subDigits = n;
        while(subDigits != 0) {
            int value = subDigits % 10;
            if (n - value >= 0 && value != 0)
                ans = Math.min(ans, 1 + solve(n - value, dp));

            subDigits /= 10;
        }
        dp[n] = ans;
        return ans;
    }

}
