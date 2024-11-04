//Implement job sequencing with deadlines using greedy method

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id;     
    int deadline; 
    int profit;  

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class jobSequencing {
    public static void scheduleJobs(Job[] jobs, int n) {
        Arrays.sort(jobs, new Comparator<Job>() {	//sorting the jobs accroding to profit in desc order..
            public int compare(Job a, Job b) {
                return b.profit - a.profit;
            }
        });

        // result array for tracking free slots
        boolean[] result = new boolean[n]; 
        // To store the sequence of jobs
        int[] jobSequence = new int[n];
        
        for (int i = 0; i < jobs.length; i++) {
            for (int j = Math.min(n - 1, jobs[i].deadline - 1); j >= 0; j--) {
                if (!result[j]) {  // Free slot found
                    result[j] = true;  // Mark slot as occupied
                    jobSequence[j] = i; // Add this job to the result sequence
                    break;
                }
            }
        }

        System.out.println("The job sequence to maximize profit is: ");
        for (int i = 0; i < n; i++) {
            if (result[i]) {
                System.out.print("Job " + jobs[jobSequence[i]].id + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job(1, 2, 100),
            new Job(2, 1, 19),
            new Job(3, 2, 27),
            new Job(4, 1, 25),
            new Job(5, 3, 15)
        };
        
        int n = 3;  // Number of available time slots

        scheduleJobs(jobs, n);
    }
}
