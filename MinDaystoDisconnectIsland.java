//Leetcode problem: 1568. Minimum Number of Days to Disconnect Island
public class MinDaystoDisconnectIsland
{
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 1 && m == 1) {
            return 1;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                if (grid[0][i] == 1) {
                    grid[0][i] = 0;
                    if (!isConnected(grid)) {
                        return 1;
                    }
                    grid[0][i] = 1;
                }
            }
            return 2;
        }
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                if (grid[i][0] == 1) {
                    grid[i][0] = 0;
                    if (!isConnected(grid)) {
                        return 1;
                    }
                    grid[i][0] = 1;
                }
            }
            return 2;
        }
        if (!isConnected(grid)) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (!isConnected(grid)) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
    public boolean isConnected(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count == 1;
    }
    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited); // explore top cell
        dfs(grid, i + 1, j, visited); // explore bottom cell
        dfs(grid, i, j - 1, visited); // explore left cell
        dfs(grid, i, j + 1, visited); // explore right cell
    }
    public static void main(String[] args) {
        // int[][] grid = {{1, 1}, {1, 0}};
        // MinDaystoDisconnectIsland obj = new MinDaystoDisconnectIsland();
        // System.out.println(obj.minDays(grid));
        int[][] grid = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        MinDaystoDisconnectIsland obj = new MinDaystoDisconnectIsland();
        int minDays = obj.minDays(grid);
        System.out.println(minDays);
    }
}