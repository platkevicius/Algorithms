package backtracking;

public class SudokuSolver {

    private int [][] sudoku;

    public static void main(String[] args) {
        int[][] sudoku = {{5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
        SudokuSolver sudokuSolver = new SudokuSolver(sudoku);
        sudokuSolver.solveSudoku(0, 0);
        sudokuSolver.printOutSudoku();
    }

    public SudokuSolver(int[][] sudoku) {
        this.sudoku = sudoku;
    }

    public boolean solveSudoku(int x, int y) {
        if (x == 9) {
            x = 0;
            y++;
        }

        if (y == 9 && x == 0)
            return true;

        if (sudoku[y][x] != 0)
            return solveSudoku(x+1, y);

        for (int i = 1; i < 10; i++) {
            if (validPosition(i, x, y)) {
                sudoku[y][x] = i;
                if (solveSudoku(x+1, y)) return true;
            }

            sudoku[y][x] = 0;
        }

        return false;
    }

    private boolean validPosition(int value, int x, int y) {
        // Waagerecht
        for (int i = 0; i < sudoku[y].length; i++) {
            if (sudoku[y][i] == value) return false;
        }

        // Senkrecht
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][x] == value) return false;
        }

        // Viereck
        int boxX = (x / 3) * 3;
        int boxY = (y / 3) * 3;

        for (int i = boxX; i < (x / 3) * 3 + 3; i++) {
            for (int j = boxY; j < (y / 3) * 3 + 3; j++) {
                if (sudoku[j][i] == value) return false;
            }
        }

        return true;
    }

    public void printOutSudoku() {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku[i].length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

}
