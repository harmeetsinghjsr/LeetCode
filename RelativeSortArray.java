//Problem 1122
//Leetcode Problem: https://leetcode.com/problems/relative-sort-array/
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;
        int c[] = new int[1001]; // Count array to store the frequency of each element in arr1
        for(int i=0;i<n;i++)
        {
            c[arr1[i]]++;
        }
        int k=0;
        for(int i=0;i<m;i++)
        {
            while(c[arr2[i]] > 0) // If the element is present in arr2
            {
                arr1[k++] = arr2[i]; // Add the element to arr1
                c[arr2[i]]--; // Decrement the frequency of the element
            }
        }
        for(int i=0;i<1001;i++)
        {
            while(c[i] > 0) // If the element is not present in arr2
            {
                arr1[k++] = i; // Add the element to arr1
                c[i]--; // Decrement the frequency of the element
            }
        }
        return arr1;
    }
    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};
        int res[] = r.relativeSortArray(arr1, arr2);
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i] + " ");
        }
    }
}