//Problem: 1051. Height Checker
//LeetCode: https://leetcode.com/problems/height-checker/
public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        
        return count;
    }
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
}