//Leetcode Problem 1514. Path with Maximum Probability
public class MaxPathProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer, List<double[]>> graph = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new double[]{v, w});
            graph.get(v).add(new double[]{u, w});
        }
        double[] prob = new double[n];
        prob[start] = 1;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        pq.offer(new double[]{start, 1});
        while(!pq.isEmpty()) {
            double[] curr = pq.poll();
            int u = (int) curr[0];
            double w = curr[1];
            if(u == end) {
                return w;
            }
            for(double[] next : graph.getOrDefault(u, new ArrayList<>())) {
                int v = (int) next[0];
                double p = next[1];
                if(w * p > prob[v]) {
                    prob[v] = w * p;
                    pq.offer(new double[]{v, w * p});
                }
            }
        }
        return 0;
    }
}