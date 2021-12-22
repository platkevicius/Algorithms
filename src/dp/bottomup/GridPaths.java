package dp.bottomup;

public class GridPaths {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        System.out.println(solve(grid));
    }

    private static int solve(int[][] grid) {
        int n = grid.length;
        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] != 1)
                dp[i][0] = 1;

            if (grid[0][i] != 1)
                dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) continue;

                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[n-1][n-1];
    }

}
