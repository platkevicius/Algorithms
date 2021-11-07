package dp.topdown;

public class DiceCombination {

    public static void main(String[] args) {
        DiceCombination diceCombination = new DiceCombination();

        System.out.println(diceCombination.solve(12, new int[13]));
    }

    public int solve(int n, int[] dp) {
        if (n == 0) return 1;
        if (dp[n] != 0) return dp[n];

        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            if (n - i >= 0)
                ans += solve(n - i, dp);
        }

        dp[n] = ans;
        return ans;
    }

}
