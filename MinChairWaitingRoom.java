import java.util.Arrays;
import java.util.PriorityQueue;
public class MinChairWaitingRoom
{
    public static int minChair(int[] arrival, int[] departure) {
        int n = arrival.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = arrival[i];
            arr[i][1] = departure[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);
        for (int i = 1; i < n; i++) {
            if (arr[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i][1]);
        }
        return pq.size();
    }
    public static void main(String[] args) {
        int[] arrival = {1, 2, 6, 5, 3};
        int[] departure = {5, 5, 7, 6, 8};
        System.out.println(minChair(arrival, departure));
    }
}