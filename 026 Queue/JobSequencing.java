import java.util.*;

class Job {
    String id;
    int deadline;
    int profit;

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    // Function to schedule jobs to maximize profit
    public static void jobScheduling(Job[] jobs) {
        // Sort jobs in decreasing order of profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline to size the slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.deadline);
        }

        String[] result = new String[maxDeadline + 1]; // Slots start from 1 index
        Arrays.fill(result, "");

        for (Job job : jobs) {
            // Find a free slot for this job (from its deadline to 1)
            for (int slot = job.deadline; slot >= 1; slot--) {
                if (result[slot].equals("")) {
                    result[slot] = job.id; // Assign job
                    break;
                }
            }
        }

        // Print scheduled jobs
        for (int i = 1; i <= maxDeadline; i++) {
            if (!result[i].equals("")) {
                System.out.print(result[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job("a", 4, 20),
            new Job("b", 1, 10),
            new Job("c", 1, 40),
            new Job("d", 1, 30)
        };

        jobScheduling(jobs);  // Output: c a
    }
}
