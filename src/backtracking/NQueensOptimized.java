package backtracking;

import java.util.Arrays;

public class NQueensOptimized {

    private int[] board;

    public static void main(String[] args) {
        NQueensOptimized nQueensOptimized = new NQueensOptimized(4);
        nQueensOptimized.solve(0);
        nQueensOptimized.printOut();
    }

    public NQueensOptimized(int n) {
        this.board = new int[n];

        Arrays.fill(board, -1);
    }

    public boolean solve(int row) {
        if (row == board.length) return true;

        for (int col = 0; col < board.length; col++) {
            if (isValid(row, col)) {
                board[row] = col;
                if (solve(row + 1)) return true;
                board[row] = -1;
            }
        }

        return false;
    }

    public boolean isValid(int row, int col) {
        // col
        for (int i = 0; i < board.length; i++)
            if (board[i] == col) return false;

        // lu -> ro
        int i = row, j = col;
        while (i != 0 && j != board.length) {
            if (board[i] == j) return false;

            i -= 1;
            j += 1;
        }

        // ro -> lu
        i = row;
        j = col;
        while (i != board.length && j != 0) {
            if (board[i] == j) return false;

            i += 1;
            j -= 1;
        }

        // lo -> ru
        i = row;
        j = col;
        while (i != board.length && j != board.length) {
            if (board[i] == j) return false;

            i += 1;
            j += 1;
        }

        // ru -> lo
        i = row;
        j = col;
        while (i != -1 && j != -1) {
            if (board[i] == j) return false;

            i -= 1;
            j -= 1;
        }

        return true;
    }

    public void printOut() {
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i] + " ");
        }
    }

}
