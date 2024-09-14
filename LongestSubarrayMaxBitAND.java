//Leetcode Problem 2419. Longest Subarray With Maximum Bitwise AND
public class LongestSubarrayMaxBitAND {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] & nums[i];
        }
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] & nums[i];
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int l = i == 0 ? 0 : prefix[i - 1];
            int r = i == n - 1 ? 0 : suffix[i + 1];
            ans = Math.max(ans, l & nums[i] & r);
        }
        return ans;
    }
}
public static void main(String[] args) {
    LongestSubarrayMaxBitAND solution = new LongestSubarrayMaxBitAND();
    int[] nums1 = {1, 2, 3, 3, 2, 2};
    int[] nums2 = {1, 2, 3, 4};
    System.out.println(solution.longestSubarray(nums1)); // Output: 2
    System.out.println(solution.longestSubarray(nums2)); // Output: 1
}