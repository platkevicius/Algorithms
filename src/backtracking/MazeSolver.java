package backtracking;

public class MazeSolver {

    private char[][] maze;

    public static void main(String[] args) {
        char[][] maze = {{'#', ' ', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', '#', '#', '#', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', ' ', ' ', '#'},
                {'#', '#', '#', '#', '#', ' ', '#'}};

        MazeSolver mazeSolver = new MazeSolver(maze);
        mazeSolver.solveMaze(0, 1);
        mazeSolver.printOut();
    }

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public boolean solveMaze(int row, int column) {
        if (row == maze.length) return true;

        for (Direction dir : Direction.values()) {
            if (valid(row, column)) {
                maze[row][column] = '.';
                if (solveMaze(row + dir.getRow(), column + dir.getColumn())) return true;
                maze[row][column] = ' ';
            }

        }

        return false;
    }

    public boolean valid(int row, int column) {
        return row >= 0 && row < maze.length && column >= 0 && column < maze[row].length && maze[row][column] == ' ';
    }

    public void printOut() {
        for (int row = 0; row < maze.length; row++) {
            for (int column = 0; column < maze[row].length; column++) {
                System.out.print(maze[row][column]);
            }
            System.out.println();
        }
    }

    enum Direction {
        LEFT(0, -1), RIGHT(0, 1), UP(-1, 0), DOWN(1, 0);

        private final int row, column;

        Direction(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}
