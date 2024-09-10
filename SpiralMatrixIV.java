package LeetCode;

public class SpiralMatrixIV {
    public int[][] generateMatrix(int n,int m,ListNode head)
    {
        int[][] matrix = new int[n][m];
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = head.val;
                head = head.next;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = head.val;
                head = head.next;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = head.val;
                    head = head.next;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = head.val;
                    head = head.next;
                }
                left++;
            }
        }
        return matrix;
    }
}