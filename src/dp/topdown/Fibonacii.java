package dp.topdown;

import java.util.Arrays;

public class Fibonacii {

    public static void main(String[] args) {
        Fibonacii fibonacii = new Fibonacii(10);
        System.out.println(fibonacii.solve(9));
    }

    private final int[] mem;

    public Fibonacii(int n) {
        mem = new int[n];

        Arrays.fill(mem, -1);
        mem[0] = 0;
        mem[1] = 1;
    }

    public int solve(int n) {
        if (mem[n] != -1)
            return mem[n];

        mem[n] = solve(n-1) + solve(n-2);
        return mem[n];
    }

}
