import java.util.*;
public class Job {
    public static int[] jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);
        int md = 0;
        for (int[] job : jobs) {
            md = Math.max(md, job[1]);
        }
        boolean[] timeSlots = new boolean[md + 1];
        int jobCount = 0;
        int totalProfit = 0;
        for (int[] job : jobs) {
            int id = job[0];
            int deadline = job[1];
            int profit = job[2];
            for (int t = deadline; t > 0; t--) {
                if (!timeSlots[t]) {
                    timeSlots[t] = true;
                    jobCount++;
                    totalProfit += profit;
                    break;
                }
            }
        }
        return new int[] {jobCount, totalProfit};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = in.nextInt();
            jobs[i][1] = in.nextInt();
            jobs[i][2] = in.nextInt();
        }
        int[] result = Job.jobScheduling(jobs);
        System.out.println(result[0] + " " + result[1]);
    }
}
