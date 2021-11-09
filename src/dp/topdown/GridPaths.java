package dp.topdown;

import java.util.Arrays;

public class GridPaths {

    public static void main(String[] args) {
        GridPaths gridPaths = new GridPaths();
        int[][] dp = new int[4][4];
        int[][] grid = new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0}
        };

        for (int[]a:dp)
            Arrays.fill(a, -1);

        System.out.println(gridPaths.solve(dp, grid, 3, 3));
    }

    public int solve(int[][] dp, int[][] grid, int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i == -1 || j == -1 || grid[i][j] == 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = solve(dp, grid, i-1, j) + solve(dp, grid, i, j-1);
    }

}
