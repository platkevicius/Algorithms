package dp.bottomup;

public class GridPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {5, 10, 7, 8},
                {1, 3, 5, 8},
                {1, 2, 20, 2},
                {1, 2, 3, 0}
        };

        System.out.println(solve(grid));
    }

    private static int solve(int grid[][]) {
        int n = grid.length;
        int dp[][] = new int[n][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
            }
        }

        return dp[n-1][n-1];
    }

}
