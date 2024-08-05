import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Leetcode problem: 2053. Kth Distinct String in an Array
//Problem link: https://leetcode.com/problems/kth-distinct-string-in-an-array/
public class KthDistinctStringArray {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String s : arr) {
            countMap.put(s, countMap.getOrDefault(s, 0) + 1);
        }
        int distinctCount = 0;
        for (String s : arr) {
            if (countMap.get(s) == 1) {
                distinctCount++;
                if (distinctCount == k) {
                    return s;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        KthDistinctStringArray ob = new KthDistinctStringArray();
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        int k = 2;
        System.out.println(ob.kthDistinct(arr, k));
    }
}