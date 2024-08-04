//Leetcode problem: 1508. Range Sum of Sorted Subarray Sums
public class RangeSumSorted {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] subarraySums = new int[n * (n + 1) / 2];
        int index = 0;
        
        // Compute all non-empty continuous subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                subarraySums[index++] = sum;
            }
        }
        
        // Sort the subarray sums in non-decreasing order
        Arrays.sort(subarraySums);
        
        // Calculate the sum of the numbers from index left to index right
        int sum = 0;
        for (int i = left - 1; i <= right - 1; i++) {
            sum = (sum + subarraySums[i]) % (int)(1e9 + 7);
        }
        
        return sum;
    }
    public static void main(String[] args) {
        RangeSumSorted obj = new RangeSumSorted();
        int[] nums = {1, 2, 3, 4};
        int n = 4;
        int left = 1;
        int right = 5;
        System.out.println(obj.rangeSum(nums, n, left, right));
    }
}