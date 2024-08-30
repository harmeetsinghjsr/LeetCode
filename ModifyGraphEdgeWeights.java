//Leetcode Problem 2699. Modify Graph Edge Weights
public class ModifyGraphEdgeWeights {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            if(edge[0] == source || edge[1] == source || edge[0] == destination || edge[1] == destination) {
                edge[2] = edge[2] * target;
            }
        }
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        int count = n;
        for(int[] edge : edges) {
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if(p1 != p2) {
                parent[p1] = p2;
                count--;
            }
        }
        int[][] result = new int[n - 1][3];
        int index = 0;
        for(int[] edge : edges) {
            if(findParent(parent, edge[0]) != findParent(parent, edge[1])) {
                result[index++] = edge;
                parent[findParent(parent, edge[0])] = findParent(parent, edge[1]);
            }
        }
        return result;
    }
}