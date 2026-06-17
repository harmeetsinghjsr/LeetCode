public class majorityElement{
    public int majorityElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int c=0;
            for(int j=0;j<n;j++)
            {
                if(nums[i]==nums[j])
                c++;
            }
            if(c>(n/2))
            return nums[i];
        }
        return -1;
    }
    public static void main(String[] args)
    {
        majorityElement me = new majorityElement();
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(me.majorityElement(nums));
    }
}