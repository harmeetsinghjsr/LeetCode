//Leetcode problem 959. Regions Cut By Slashes
public class RegionsCutbySlashes {
    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[n*3][n*3];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i].charAt(j)=='/'){
                    g[i*3][j*3+2] = 1;
                    g[i*3+1][j*3+1] = 1;
                    g[i*3+2][j*3] = 1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    g[i*3][j*3] = 1;
                    g[i*3+1][j*3+1] = 1;
                    g[i*3+2][j*3+2] = 1;
                }
            }
        }
        int count = 0;
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n*3;j++){
                if(g[i][j]==0){
                    dfs(g,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void dfs(int[][] g,int i,int j){
        if(i<0 || j<0 || i>=g.length || j>=g[0].length || g[i][j]==1){
            return;
        }
        g[i][j] = 1;
        dfs(g,i+1,j);
        dfs(g,i-1,j);
        dfs(g,i,j+1);
        dfs(g,i,j-1);
    }
    public static void main(String[] args) {
        String[] grid = {" /","/ "};
        System.out.println(regionsBySlashes(grid));
    }
}