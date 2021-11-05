package recursive;

public class PathsCounterProblem {

    public static void main(String[] args) {
        PathsCounterProblem pathsCounterProblem = new PathsCounterProblem();

        System.out.println(pathsCounterProblem.countPaths(3, 3));
    }

    public int countPaths(int m, int n) {
        if (m == 1 || n == 1) return 1;

        return countPaths(m-1,n)+countPaths(m,n-1);
    }

}
