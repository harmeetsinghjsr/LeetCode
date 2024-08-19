//Leetcode Problem: 650. 2 Keys Keyboard
public class IIKeysKeyboard {
    public int minSteps(int  n){
        int[] dp =new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i]=i;
            for(int j=i-1;j>1;j--){
                if(i%j==0){
                    dp[i]=dp[j]+i/j;
                    break;
                }
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        IIKeysKeyboard obj = new IIKeysKeyboard();
        int x = obj.minSteps(3);
        System.out.println(x);
    }
}