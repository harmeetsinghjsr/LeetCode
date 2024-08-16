//Leetcode Problem 719. Find K-th Smallest Pair Distance
public class KthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int[] count = new int[1000000];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                count[Math.abs(nums[i] - nums[j])]++;
        }
        for (int i = 0; i < 1000000; i++) {
            if (count[i] >= k)
                return i;
            k -= count[i];
        }
        return 0;
    }
}