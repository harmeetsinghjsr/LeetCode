//Leetcode Problem 386. Lexicographical Numbers
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    private void dfs(int num, int n, List<Integer> result) {
        if(num > n) {
            return;
        }
        result.add(num);
        for(int i = 0; i < 10; i++) {
            if(num * 10 + i <= n) {
                dfs(num * 10 + i, n, result);
            }
        }
    }
}