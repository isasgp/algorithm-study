import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 1_000;
    private static final int MOD = 1_000_000_007;

    private static long solution(int n) {
        long[] dp = new long[MAX_NUM+1];
        
        dp[1] = 2;
        dp[2] = 7;

        for(int i=3; i<=n; i++) {
            long num = dp[i-1] % MOD;
            for(int j=0; j<dp[i-2]*2; j++) {
                // System.out.println(num);
                dp[i] += num--;
            }
        }
        // System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        long result = solution(n);

        System.out.println(result);
    }
}