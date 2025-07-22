import java.util.*;

public class JobSequencing {
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int maxProfit(Job[] jobs) {
        // Step 1: Sort jobs by profit descending
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int n = jobs.length;
        boolean[] slot = new boolean[n + 1]; // slots tracking (1-based)
        int totalProfit = 0;

        // Step 2: Greedy allocation
        for (Job job : jobs) {
            // Find latest available slot before deadline
            for (int j = Math.min(n, job.deadline); j > 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100), new Job(2, 1, 19), new Job(3, 2, 27),
            new Job(4, 1, 25), new Job(5, 3, 15)
        };
        System.out.println("Maximum Profit: " + maxProfit(jobs));
    }
}
