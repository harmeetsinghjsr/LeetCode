// package LeetCode;
import java.util.Arrays;
public class MinIncrementToUnique {
    public int minIncrementForUnique(int nums[])
    {
        int n = nums.length;
        int c=0;
        Arrays.sort(nums); // Sort the array to handle duplicates efficiently
        for(int i=1;i<n;i++)
        {
            if(nums[i] <= nums[i-1]) // If current number is less than or equal to previous number
            {
                c += nums[i-1] - nums[i] + 1; // Increment the current number to make it unique
                nums[i] = nums[i-1] + 1; // Update the current number to the new unique value
            }
        }
        return c;
    }
    public static void main(String[] args) {
        MinIncrementToUnique m = new MinIncrementToUnique();
        int nums[] = {3,2,1,2,1,7};
        System.out.println(m.minIncrementForUnique(nums));
    }
}