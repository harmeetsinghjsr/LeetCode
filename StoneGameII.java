//Leetcode problem: 1140. Stone Game II
public class StoneGameII {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n-1] = piles[n-1];
        for(int i = n-2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i+1] + piles[i];
        }
        int[][] dp = new int[n][n];
        return stoneGameII(piles, 0, 1, suffixSum, dp);
    }
    
    private int stoneGameII(int[] piles, int i, int M, int[] suffixSum, int[][] dp) {
        if(i == piles.length) {
            return 0;
        }
        if(2*M >= piles.length - i) {
            return suffixSum[i];
        }
        if(dp[i][M] != 0) {
            return dp[i][M];
        }
        int min = Integer.MAX_VALUE;
        for(int x = 1; x <= 2*M; x++) {
            min = Math.min(min, stoneGameII(piles, i+x, Math.max(M, x), suffixSum, dp));
        }
        dp[i][M] = suffixSum[i] - min;
        return dp[i][M];
    }
}