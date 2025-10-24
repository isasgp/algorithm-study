import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 1_000;
    private static final int MOD = 10_007;

    private static long solution(int n) {
        long[] dp = new long[MAX_NUM+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
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