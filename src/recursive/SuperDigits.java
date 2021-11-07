package recursive;

public class SuperDigits {

    public static void main(String[] args) {
        SuperDigits superDigits = new SuperDigits();

        System.out.println(superDigits.superDigit("123", 3));
    }

    public int superDigit(String n, int k) {
        String problem = "";
        for (int i = 0; i < k; i++)
            problem += n;

        return solve(problem);
    }

    private int solve(String number) {
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            int num = Integer.parseInt(String.valueOf(number.charAt(i)));
            sum += num;
        }

        if (sum > 9)
            return solve(String.valueOf(sum));

        return sum;
    }
}
