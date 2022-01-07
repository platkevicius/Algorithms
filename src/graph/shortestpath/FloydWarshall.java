package graph.shortestpath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.POSITIVE_INFINITY;

public class FloydWarshall {

    private final int n;
    private final double[][] dp;
    private final Integer[][] next;

    private boolean solved;

    private static final int REACHES_NEGATIVE_CYCLE = -1;

    public FloydWarshall(double[][] matrix) {
        n = matrix.length;
        dp = new double[n][n];
        next = new Integer[n][n];

        // Copy input matrix and setup 'next' matrix for path reconstruction.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != POSITIVE_INFINITY) next[i][j] = j;
                dp[i][j] = matrix[i][j];
            }
        }
    }

    private double[][] getApspMatrix() {
        solve();
        return dp;
    }

    private void solve() {
        if (solved) return;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        // check for negative cycles
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j] && dp[i][k] != POSITIVE_INFINITY && dp[k][k] < 0) {
                        dp[i][j] = NEGATIVE_INFINITY;
                        next[i][j] = REACHES_NEGATIVE_CYCLE;
                    }
                }
            }
        }

        solved = true;
    }

    public List<Integer> reconstructPath(int from, int to) {
        solve();

        List<Integer> path = new ArrayList<>();

        if (dp[from][to] == POSITIVE_INFINITY) return path;

        int at = from;
        while (at != to) {
            if (next[at][to] == REACHES_NEGATIVE_CYCLE) return null;

            path.add(at);
            at = next[at][to];
        }

        path.add(to);
        return path;
    }

    public static double[][] createGraph(int n) {
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(matrix[i], POSITIVE_INFINITY);
            matrix[i][i] = 0;
        }
        return matrix;
    }

    public static void main(String[] args) {
        // Construct graph.
        int n = 7;
        double[][] m = createGraph(n);

        // Add some edge values.
        m[0][1] = 2;
        m[0][2] = 5;
        m[0][6] = 10;
        m[1][2] = 2;
        m[1][4] = 11;
        m[2][6] = 2;
        m[6][5] = 11;
        m[4][5] = 1;
        m[5][4] = -2;

        FloydWarshall solver = new FloydWarshall(m);
        double[][] dist = solver.getApspMatrix();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                System.out.printf("This shortest path from node %d to node %d is %.3f\n", i, j, dist[i][j]);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> path = solver.reconstructPath(i, j);

                if (path == null) {
                    System.out.println("NO PATH");
                } else if (path.isEmpty()) {
                    System.out.println("NEGATIVE CYCLE");
                } else {
                    for (int node : path) {
                        System.out.print(node + "->");
                    }
                    System.out.println();
                }
            }
        }
    }
}
