package Backtracking;

import java.util.Set;
import java.util.Stack;

public class SubSetSumSolver {

    private int[] elements;

    public static void main(String[] args) {
        SubSetSumSolver subSetSumSolver = new SubSetSumSolver(new int[]{5, 2, 3, 1, 10, 9, 6});
        subSetSumSolver.solve(-1, 0, 10, new Stack<>());
    }

    public SubSetSumSolver(int[] elements) {
        this.elements = elements;
    }

    public void solve(int elem, int sum, int wanted, Stack<Integer> values) {
        if (sum > wanted) return;

        if (elem == elements.length - 1) return;

        for (int i = elem + 1; i < elements.length; i++) {
            if (sum + elements[i] == wanted) {
                values.push(elements[i]);
                System.out.println(values.toString());
                values.pop();
            } else if (sum + elements[i] < wanted) {
                values.push(elements[i]);
                solve(i, sum + elements[i], wanted, values);
                values.pop();
            }
        }
    }

}
