import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 19;

    private static long solution(int n) {
        long[] dp = new long[MAX_NUM+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4; i<=n; i++) {
            dp[i] = 2*dp[i-1] + 2*dp[i-2] + 2*dp[i-3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long result = solution(n);

        System.out.println(result);
    }
}