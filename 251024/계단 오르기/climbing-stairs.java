import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 1000;

    private static int solution(int n) {
        int[] dp = new int[MAX_NUM+1];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 1;

        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = solution(n);

        System.out.println(result % 10_007);
    }
}