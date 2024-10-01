//Leetcode Problem 1497 Check If Array Pairs Are Divisible by k
public class CheckIfArrayPairsAreDivisiblebyk {
    public boolean canArrange(int[] arr, int k) {
        int[] freq = new int[k];
        for(int num : arr){
            freq[(num % k + k) % k]++;
        }
        if(freq[0] % 2 != 0){
            return false;
        }
        for(int i = 1; i <= k / 2; i++){
            if(freq[i] != freq[k - i]){
                return false;
            }
        }
        return true;
    }   
}