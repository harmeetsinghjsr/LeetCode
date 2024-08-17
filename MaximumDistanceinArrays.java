//Leetcode problem: 624. Maximum Distance in Arrays
public class MaximumDistanceinArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            result = Math.max(result, Math.abs(list.get(list.size() - 1) - min));
            result = Math.max(result, Math.abs(max - list.get(0)));
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(list.size() - 1));
        }
        return result;
    }
}