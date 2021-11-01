package codemonk.array;

import java.util.Scanner;

public class RotatingArray {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int tests = s.nextInt();

        for (int i = 0; i < tests; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            int[] arr = new int[n];

            for (int j = 0; j < n; j++)
                arr[j] = s.nextInt();

            if (n == 0) {
                continue;
            }

            if (k >= n)
                k %= n;

            int[] temp = new int[k];
            int counter = 0;
            for (int l = n - k; l < n; l++) {
                temp[counter] = arr[l];
                counter++;
            }

            for (int l = n - 1; l >= k; l--)
                arr[l] = arr[l - k];

            for (int l = 0; l < k; l++) {
                arr[l] = temp[l];
            }

            for (int j = 0; j < n; j++) {
                System.out.print(arr[j] + " ");
            }

            System.out.println();
        }
    }
}
