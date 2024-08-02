import java.util.Arrays;

public class MostProfitAssigning {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Create an array of jobs with difficulty and profit
        int n = difficulty.length;
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(difficulty[i], profit[i]);
        }
        
        // Sort the jobs by difficulty
        Arrays.sort(jobs, (a, b) -> a.difficulty - b.difficulty);
        // Sort the workers by their abilities
        Arrays.sort(worker);
        
        int maxProfit = 0;
        int totalProfit = 0;
        int j = 0;
        
        // For each worker, find the best job they can perform
        for (int w : worker) {
            // Move the job pointer j to the right as long as the job difficulty is <= worker's ability
            while (j < n && jobs[j].difficulty <= w) {
                maxProfit = Math.max(maxProfit, jobs[j].profit);
                j++;
            }
            // Add the best profit that this worker can get
            totalProfit += maxProfit;
        }
        
        return totalProfit;
    }

    // Define a Job class to store difficulty and profit
    class Job {
        int difficulty;
        int profit;
        
        Job(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        MostProfitAssigning sol = new MostProfitAssigning();
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};
        System.out.println(sol.maxProfitAssignment(difficulty, profit, worker)); // Output: 100
    }
}