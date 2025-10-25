import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 19;
    private static long[] dp = new long[MAX_NUM+1];

    private static long solution(int n) {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;

        if(dp[n] != 0)
            return dp[n];
        
        long temp = 0;

        for(int i=0; i<n; i++) {
            temp += solution(i) * solution(n - i - 1);
        }
        dp[n] = temp;

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long result = solution(n);

        System.out.println(result);
    }
}