//Leetcode 2022. Convert 1D Array Into 2D Array
public class Convert1Dto2D {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[0][0];
        }
        int[][] res = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++, k++) {
                res[i][j] = original[k];
            }
        }
        return res;
    }
}