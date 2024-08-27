//Leetcode Problem 1514. Path with Maximum Probability
public class PathwithMaxProbablity {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.putIfAbsent(u, new HashMap<>());
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(u).put(v, prob);
            graph.get(v).put(u, prob);
        }
        double[] prob = new double[n];
        prob[start] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new int[]{start, 1});
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int node = current[0];
            double currentProb = current[1];
            if(node == end) return currentProb;
            for(Map.Entry<Integer, Double> entry : graph.getOrDefault(node, new HashMap<>()).entrySet()){
                int next = entry.getKey();
                double nextProb = entry.getValue();
                if(currentProb * nextProb > prob[next]){
                    prob[next] = currentProb * nextProb;
                    pq.offer(new int[]{next, (int)prob[next]});
                }
            }
        }
        return 0;
    }
}