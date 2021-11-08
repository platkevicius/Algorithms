package dp.topdown;

public class RemovingDigits {

    public static void main(String[] args) {
        RemovingDigits removingDigits = new RemovingDigits();
        System.out.println(removingDigits.solve(27));
    }

    public int solve(int n) {
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;

        int subDigits = n;
        while(subDigits != 0) {
            int value = subDigits % 10;
            if (n - value >= 0 && value != 0)
                ans = Math.min(ans, 1 + solve(n - value));

            subDigits /= 10;
        }
        return ans;
    }

}
