package dp.bottomup;

public class DiceCombination {

    public static void main(String[] args) {
        System.out.println(solve(3, new int[]{1, 2, 3, 4, 5, 6}));
    }

    private static int solve(int n, int[] dices) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int dice : dices) {
                if (i - dice >= 0)
                    dp[i] += dp[i - dice];
            }
        }

        return dp[n];
    }

}
