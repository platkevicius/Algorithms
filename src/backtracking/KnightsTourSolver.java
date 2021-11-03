package backtracking;

public class KnightsTourSolver {

    private final int[][] board;

    public static void main(String[] args) {
        KnightsTourSolver solver = new KnightsTourSolver(8);
        solver.solve(0, 0, 0);
        solver.printOut();
    }

    public KnightsTourSolver(int n) {
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }
    }

    public boolean solve(int row, int column, int counter) {
        if ((board.length * board.length) - 1 == counter) {
            board[row][column] = counter;
            return true;
        }


        for (Direction dir : Direction.values()) {
            if (isValid(row + dir.row, column + dir.column)) {
                board[row][column] = counter;

                if (solve(row + dir.row, column + dir.column, counter+1)) return true;
                else
                    board[row][column] = -1;
            }
        }

        return false;
    }

    public boolean isValid(int row, int column) {
        return row >= 0 && row < board.length && column >= 0 && column < board.length && board[row][column] == -1;
    }

    public void printOut() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public enum Direction {
        RO1(-1, 2), RO2(-2, 1), RL1(1, 2), RL2(2, 1), LO1(-2, -1), LO2(-1, -2), LD1(1, -2), LD2(2, -1);

        int row, column;

        Direction(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
