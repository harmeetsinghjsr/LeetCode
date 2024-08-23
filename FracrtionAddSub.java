// Leetcode Problem: 592. Fraction Addition and Subtraction
public class FractionAddSub {
    public String fractionAddition(String expression) {
        int n = expression.length();
        int sign = 1;
        int num = 0;
        int den = 1;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            String[] frac = expression.substring(i, j).split("/");
            int num2 = Integer.parseInt(frac[0]);
            int den2 = Integer.parseInt(frac[1]);
            num = num * den2 + sign * num2 * den;
            den = den * den2;
            int g = gcd(Math.abs(num), den);
            num /= g;
            den /= g;
            if (j < n) {
                sign = expression.charAt(j) == '+' ? 1 : -1;
            }
            i = j;
        }
        if (den == 1) {
            return num + "/1";
        } else {
            return num + "/" + den;
        }
    }

    private int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}