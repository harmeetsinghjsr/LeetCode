//Problem 53. Maximum Subarray
//problem link: https://leetcode.com/problems/maximum-subarray/
public class KadanesAlgorithm{
    public static int maxSubArray(int[] nums) {
        int sum=0;
        int res= Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum>res)res=sum;
            if(sum<0)sum=0;
        }
        return res;
    }
    public static void main(String ae[]){
        int nums[]={-1, 2, 3, -1, 2, -6, 5};
        int a = maxSubArray(nums);
        System.out.println(a);
    }
}