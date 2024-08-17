//Leetcode problem: 1937. Maximum Number of Points with Cost
public class MaxPointwithCost {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            left[0] = dp[0];
            right[n - 1] = dp[n - 1];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1] - 1, dp[j]);
            }
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1] - 1, dp[j]);
            }
            for (int j = 0; j < n; j++) {
                dp[j] = Math.max(left[j], right[j]) + points[i][j];
            }
        }
        long result = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }   
}