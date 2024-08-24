//Leetcode Problem 564 Closest Palindrome
// public class ClosestPalindrome {
//     boolean PalindromeCheck(int n)
//     {
//         int x=n;
//         int rev=0;
//         while(x!=0){
//             rev=rev*10+(x%10);
//             x/=10;
//         }
//         if(rev==n)
//         return true;
//         else
//         return false;
//     }
//     public int NearestPalindrome(int n) {
//         int i = n - 1;
//         int j = n + 1;
        
//         while (true) {
//             if (PalindromeCheck(i))
//                 return i;
//             if (PalindromeCheck(j))
//                 return j;
            
//             i--;
//             j++;
//         }
//     }
//    public static void main(String[] args) {
//         int n=120;
//         ClosestPalindrome cp = new ClosestPalindrome();
//         int result = cp.NearestPalindrome(n);
//         System.out.println(result);
//     }
// }
class ClosestPalindrome {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long i = num - 1;
        long j = num + 1;
        
        while (true) {
            if (isPalindrome(i))
                return String.valueOf(i);
            if (isPalindrome(j))
                return String.valueOf(j);
            
            i--;
            j++;
        } 
    }
    
    private boolean isPalindrome(long num) {
        String str = String.valueOf(num);
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String n="120";
        Solution cp = new Solution();
        String result = cp.nearestPalindromic(n);
        System.out.println(result);
    }
}