//Leetcode problem: 2053. Kth Distinct String in an Array
//Problem link: https://leetcode.com/problems/kth-distinct-string-in-an-array/
import java.util.Arrays;
public class KthDistinctStringArray {
    public String kthDistinct(String[] arr, int k) {
        Set<String> set = new HashSet<>();
        for (String s : arr) {
            set.add(s);
        }
        String[] distinct = set.toArray(new String[0]);
        Arrays.sort(distinct);
        return distinct[k - 1];
    }
    public static void main(String[] args) {
        KthDistinctStringArray ob = new KthDistinctStringArray();
        String[] arr = {"a", "b", "c", "a", "b", "c"};
        int k = 2;
        System.out.println(ob.kthDistinct(arr, k));
    }
}