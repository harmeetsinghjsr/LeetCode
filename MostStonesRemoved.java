//Leetcode Problem 947. Most Stones Removed with Same Row or Column
public class MostStonesRemoved {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int count = n;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    int p1 = findParent(parent, i);
                    int p2 = findParent(parent, j);
                    if(p1 != p2) {
                        parent[p1] = p2;
                        count--;
                    }
                }
            }
        }
        return n - count;
    }
    
    private int findParent(int[] parent, int i) {
        if(parent[i] != i) {
            parent[i] = findParent(parent, parent[i]);
        }
        return parent[i];
    }   
}