//Problem: 502. IPO
//problem link: https://leetcode.com/problems/ipo/
import java.util.PriorityQueue;
public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pqCap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pqPro = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < profits.length; i++) {
            pqCap.add(new int[]{capital[i], profits[i]});
        }
        for (int i = 0; i < k; i++) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= w) {
                pqPro.add(pqCap.poll());
            }
            if (pqPro.isEmpty()) {
                break;
            }
            w += pqPro.poll()[1];
        }
        return w;
    }
    public static void main(String[] args) {
        int k = 2;
        int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};
        IPO obj = new IPO();
        System.out.println(obj.findMaximizedCapital(k, w, profits, capital));
    }
}