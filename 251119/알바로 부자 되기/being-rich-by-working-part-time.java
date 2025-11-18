import java.util.*;
public class Main {
    private static class Job {
        int start;
        int end;
        int pay;
        private Job(int start, int end, int pay) {
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Job> arr = new ArrayList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();
            arr.add(new Job(s, e, p));
        }

        arr.sort((o1, o2) -> {
            if(o1.start == o2.start)
                return Integer.compare(o1.end, o2.end);
            return Integer.compare(o1.start, o2.start);
        });
        
        for(int i=0; i<n; i++) {
            Job currJob = arr.get(i);
            dp[i] = currJob.pay;

            for(int j=0; j<i; j++) {
                Job pastJob = arr.get(j);
                if(currJob.start > pastJob.end ||
                currJob.end < pastJob.start)
                    dp[i] = Math.max(dp[i], dp[j] + currJob.pay);
            }
        }

        int result = 0;
        for(int i=0; i<n; i++)
            result = Math.max(result, dp[i]);
        System.out.println(result);
    }
}