package Backtracking;

public class NQueensProblem {

    private final int board[][];

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        NQueensProblem problem = new NQueensProblem(board);
        problem.solveQueens(0);
        problem.printOut();
    }

    public NQueensProblem(int[][] board) {
        this.board = board;
    }

    public boolean solveQueens(int row) {
        if (row == board.length) return true;

        for (int i = 0; i < board[row].length; i++) {
            if (isValid(row, i)) {
                board[row][i] = 1;
                printOut();
                System.out.println();
                System.out.println();
                if (solveQueens(row+1)) return true;
                board[row][i] = 0;
            }
        }

        return false;
    }

    public boolean isValid(int row, int column) {
        // row
        for (int i = 0; i < row; i++) {
            if (board[i][column] == 1) return false;
        }

        // column
        for (int j = 0; j < column; j++) {
            if (board[row][j] == 1) return false;
        }

        // lu -> ro
        int i = row, j = column;
        while (i != 0 && j != board[0].length) {
            if (board[i][j] == 1) return false;

            i -= 1;
            j += 1;
        }

        // ro -> lu
        i = row;
        j = column;
        while (i != board.length && j != 0) {
            if (board[i][j] == 1) return false;

            i += 1;
            j -= 1;
        }

        // lo -> ru
        i = row;
        j = column;
        while (i != board.length && j != board[0].length) {
            if (board[i][j] == 1) return false;

            i += 1;
            j += 1;
        }

        // ru -> lo
        i = row;
        j = column;
        while (i != -1 && j != -1) {
            if (board[i][j] == 1) return false;

            i -= 1;
            j -= 1;
        }

        return true;
    }

    public void printOut() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
