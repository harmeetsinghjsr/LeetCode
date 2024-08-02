public class MinDaysToMakeMBouquet {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) {
            return -1;
        }
        
        int low = 1;
        int high = 1;
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMakeBouquet(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean canMakeBouquet(int[] bloomDay, int m, int k, int day) {
        int flowers = 0;
        int bouquets = 0;
        
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        
        return bouquets >= m;
    }
    
    public static void main(String[] args) {
        MinDaysToMakeMBouquet sol = new MinDaysToMakeMBouquet();
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3;
        int k = 1;
        int result = sol.minDays(bloomDay, m, k);
        if (result == -1) {
            System.out.println("It is impossible to make " + m + " bouquets.");
        } else {
            System.out.println("Minimum number of days to wait: " + result);
        }
    }
}