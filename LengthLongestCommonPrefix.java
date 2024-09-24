package LeetCode;

public class LengthLongestCommonPrefix {
    public int longestCommonPrefix(int[] arr1,int[] arr2) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] == arr2[j]){
                count++;
                i++;
                j++;
            }else{
                break;
            }
        }
        return count;
    }
}