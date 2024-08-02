//Problem: 330. Patching Array
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        long miss = 1;
        int patches = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }
    public static void main(String[] args) {
        PatchingArray pa = new PatchingArray();
        int[] nums = {1, 5, 10};
        int n = 20;
        System.out.println(pa.minPatches(nums, n));
    }
}