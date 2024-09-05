//Leetcode 2028. Find Missing Observations
public class FindMissingObservation {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = mean * (m + n);
        int sumRolls = 0;
        for (int roll : rolls) {
            sumRolls += roll;
        }
        int remainingSum = sum - sumRolls;
        if (remainingSum < n || remainingSum > 6 * n) {
            return new int[0];
        }
        int[] ans = new int[n];
        int avg = remainingSum / n;
        int rem = remainingSum % n;
        for (int i = 0; i < n; i++) {
            ans[i] = avg;
            if (rem > 0) {
                ans[i]++;
                rem--;
            }
        }
        return ans;
    }
}