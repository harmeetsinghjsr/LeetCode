// Leetcode Problem: 592. Fraction Addition and Subtraction
// public class FractionAddSub {
//     public String fractionAddition(String expression) {
//         int n = expression.length();
//         int sign = 1;
//         int num = 0;
//         int den = 1;
//         int i = 0;
//         while (i < n) {
//             int j = i + 1;
//             while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
//                 j++;
//             }
//             String[] frac = expression.substring(i, j).split("/");
//             int num2 = Integer.parseInt(frac[0]);
//             int den2 = Integer.parseInt(frac[1]);
//             num = num * den2 + sign * num2 * den;
//             den = den * den2;
//             int g = gcd(Math.abs(num), den);
//             num /= g;
//             den /= g;
//             if (j < n) {
//                 sign = expression.charAt(j) == '+' ? 1 : -1;
//             }
//             i = j;
//         }
//         if (den == 1) {
//             return num + "/1";
//         } else {
//             return num + "/" + den;
//         }
//     }

//     private int gcd(int a, int b) {
//         return a == 0 ? b : gcd(b % a, a);
//     }
// }

class FractionAddSub {
    public String fractionAddition(String expression) {
        int n = expression.length();
        int c = 0;
        for(int i=0;i<n;i++){
            if(expression.charAt(i)=='/'){
                c++;
            }
        }
        int[] num = new int[c];
        int[] den = new int[c];
        int[] s = new int[c];
        int i = 0;
        if(expression.charAt(0)=='-'){
            s[0]=-1;
            i=1;
        }
        else{
            s[0]=1;
        }
        int j=0,k=0,l=1;
        while (i < n) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-') {
                    s[l] = -1;
                } else {
                    s[l] = 1;
                }
                l++;
                i++;
            }
            int nu=0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                nu=nu*10+(expression.charAt(i)-'0');
                i++;
            }
            num[j++] = nu;
            i++; 
            int de = 0;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                de=de* 10+(expression.charAt(i)-'0');
                i++;
            }
            den[k++]=de;
        }
        int lcm = den[0];
        for(i=1;i<c;i++){
            lcm = lcm*(den[i]/helper(lcm,den[i]));;
        }
        for(i=0;i<c;i++){
            int a = (lcm/den[i])*s[i];
            num[i]*=a;
        }
        int sum=0;
        for(i=0;i<c;i++){
            sum+=num[i];
        }
        int x = helper(Math.abs(sum),lcm);
        sum=sum/x;
        lcm=lcm/x;
        String str = Integer.toString(sum)+"/"+Integer.toString(lcm);
        return str;
    }
    public static int helper(int a,int b) {
        if (b==0)
            return a;
        return helper(b, a % b);
    }
    public static void main(String[] args) {
        FractionAddSub fas = new FractionAddSub();
        String expression = "-1/2+1/2";
        System.out.println(fas.fractionAddition(expression));
    }   
}