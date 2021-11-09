package dp.topdown;

import java.util.Arrays;

public class GridPathSum {

    public static void main(String[] args) {
        GridPathSum gridPathSum = new GridPathSum();

        int[][] dp = new int[4][4];
        int[][] grid = new int[][]{
                {5, 10, 7, 8},
                {1, 3, 5, 8},
                {1, 2, 20, 2},
                {1, 2, 3, 0}
        };

        for (int[] a : dp)
            Arrays.fill(a, -1);

        System.out.println(gridPathSum.solve(dp, grid, 3, 3));
    }

    public int solve(int[][] dp, int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];

        if (i - 1 >= 0 && j-1 >= 0)
            dp[i][j] = Math.min(solve(dp, grid, i - 1, j) + grid[i][j],
                                solve(dp, grid, i, j - 1) + grid[i][j]);
        else if (i - 1 < 0)
            dp[i][j] = solve(dp, grid, i, j-1) + grid[i][j];
        else
            dp[i][j] = solve(dp, grid, i - 1, j) + grid[i][j];

        return dp[i][j];
    }
}
