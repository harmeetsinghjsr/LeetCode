//Problem1: Two Sum
// URL: https://leetcode.com/problems/two-sum/
// public class TwoSum {
//     public static void main(String[] args)
//     {
//         int[] nums={2,7,11,15};
//         int target=9;
//         for(int i=0;i<nums.length;i++)
//         {
//             for(int j=0;j<i;j++)
//             {
//                 if(nums[i]+nums[j]==target)
//                 {
//                     System.out.println("["+j+","+i+"]");
//                 }
//             }
//         }
//     }
// }
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    result[0]=j;
                    result[1]=i;
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] nums={2,7,11,15};
        int target=9;
        int[] result=twoSum(nums,target);
        System.out.println("["+result[0]+","+result[1]+"]");
    }
}