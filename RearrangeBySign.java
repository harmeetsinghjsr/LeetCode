//Leetcode Problem 2149: Rearrange Array Elements by Sign

public class RearrangeBySign {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int pos[]=new int[n/2];
        int neg[]=new int[n/2];
        int a=0,b=0,k=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0){
                pos[a]=nums[i];
                a++;
            }
            else
            {
                neg[b]=nums[i];
                b++;
            }
        }
        for(int i=0;i<n/2;i++){
            nums[k++]=pos[i];
            nums[k++]=neg[i]; 
        }
        return nums;
    }
    public static void main(String[] args) {
        RearrangeBySign obj = new RearrangeBySign();
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] result = obj.rearrangeArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}