//885. Spiral Matrix III
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int len = 0, d = 0, step = 0;
        res[0] = new int[]{r0, c0};
        int count = 1;
        while (len < R * C) {
            for (int i = 0; i < count; i++) {
                r0 += dirs[d][0];
                c0 += dirs[d][1];
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    res[len++] = new int[]{r0, c0};
                }
            }
            if (d == 0 || d == 2) {
                count++;
            }
            d = (d + 1) % 4;
        }
        return res;
    }
    public static void main(String[] args) {
        SpiralMatrixIII obj = new SpiralMatrixIII();
        int R = 5, C = 6, r0 = 1, c0 = 4;
        int[][] res = obj.spiralMatrixIII(R, C, r0, c0);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " + res[i][1]);
        }
    }
}