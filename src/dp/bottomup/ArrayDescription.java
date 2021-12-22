package dp.bottomup;

public class ArrayDescription {

    public static void main(String[] args) {

    }

    private static int solve(int[] values, int upper) {
        int dp[][] = new int[values.length][upper + 1];

        // base cases
        if (values[0] != 0)
            dp[0][values[0]] = 1;
        else
            for (int i = 1; i <= upper; i++)
                dp[0][i] = 1;

        for (int i = 1; i < values.length; i++) {
            if (values[i] == 0) {
                for (int j = 1; j <= upper; j++) {
                    if (j - i >= 1)
                        dp[i][j] += dp[i-1][j-1];
                    dp[i][j] += dp[i-1][j];
                    if (j + 1 <= values.length)
                        dp[i][j] += dp[i-1][j+1];
                }
            } else {
                if (values[i]-1 >= 1)
                    dp[i][values[i]] += dp[i-1][values[i]-1];
                dp[i][values[i]] += dp[i-1][values[i]];
                if (values[i]+1 <= values.length)
                    dp[i][values[i]] += dp[i-1][values[i]+1];
            }
        }

        int ans = 0;
        for (int i = 0; i <= upper; i++)
            ans += dp[values.length-1][i];

        return ans;
    }
}
