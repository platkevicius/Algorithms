package dp.topdown;

import java.util.Arrays;

public class ArrayDescription {

    public static void main(String[] args) {
        ArrayDescription arrayDescription = new ArrayDescription();

        int[][] dp = new int[3][3];
        for (int[]a:dp)
            Arrays.fill(a, -1);
        int[] arr = new int[]{2,0,2};

        System.out.println(arrayDescription.solve(dp, arr, 2, -1, 3));
    }

    public int solve(int[][] dp, int[] arr, int i, int value, int upper) {
        if (i == -1) return 1;
        if (value != -1 && arr[i]!=0 && Math.abs(value - arr[i]) > 1) return 0;
        if (dp[arr[i]][i] != -1) return dp[arr[i]][i];

        int ans = 0;

        if (arr[i] == 0) {
            for (int u = 1; u <= upper; u++) {
                if (Math.abs(value - u) <= 1 || value == -1)
                    ans += solve(dp, arr, i-1, u, upper);
            }
        } else {
            ans += solve(dp, arr, i-1, arr[i], upper);
        }

        return dp[arr[i]][i] = ans;
    }

}
