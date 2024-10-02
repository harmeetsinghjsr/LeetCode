//Leetcode Problem 1331. Rank Transform of an Array
public class RankTransformofanArray {
    public int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : sortedArr){
            if(!map.containsKey(num)){
                map.put(num, rank++);
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}