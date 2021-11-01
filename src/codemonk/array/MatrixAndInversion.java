package codemonk.array;

import java.util.Scanner;

public class MatrixAndInversion {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        while (t != 0) {
            int n = s.nextInt();

            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int value = s.nextInt();
                    matrix[i][j] = value;
                }
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = i; k < n; k++) {
                        for (int l = j; l < n; l++) {
                            if (matrix[i][j] > matrix[k][l])
                                ans++;
                        }
                    }
                }
            }

            System.out.println(ans);
            t-=1;
        }
    }

}
