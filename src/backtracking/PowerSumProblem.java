package backtracking;

import java.util.Stack;

public class PowerSumProblem {

    public static void main(String[] args) {
        PowerSumProblem powerSumProblem = new PowerSumProblem();

        System.out.println(powerSumProblem.solve(29, 2, new Stack<>()));
    }

    public int solve(int x, int n, Stack<Integer> values) {
        int sum = 0;
        for (int elem : values)
            sum += Math.pow(elem, n);

        if (sum == x) {
            return 1;
        } else {
            int answer = 0;
            int v = values.empty() ? 1 : values.lastElement() + 1;

            while (sum + Math.pow(v, n) <= x) {
                values.push(v);
                answer += solve(x, n, values);
                values.pop();
                v++;
            }

            return answer;
        }
    }

}
