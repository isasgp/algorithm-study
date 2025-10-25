import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 1_000;
    private static final int MOD = 1_000_000_007;

    private static long solution(int n) {
        long[] dp = new long[MAX_NUM+1];
        
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for(int i=3; i<=n; i++) {
            dp[i] = ((dp[i-1] * 2L) + (dp[i-2] * 3L)) % MOD;
            for(int j=i-3; j>=0; j--) {
                dp[i] = (dp[i] + dp[j] * 2L) % MOD;
            }
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