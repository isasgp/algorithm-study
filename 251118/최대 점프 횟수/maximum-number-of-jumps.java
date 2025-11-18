import java.util.Scanner;

public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++)
            dp[i] = INT_MIN;
        dp[0] = 0;

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] == INT_MIN)
                    continue;
                
                if(j + arr[j] >= i)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int result = 0;
        
        for(int i=0; i<n; i++)
            result = Math.max(result, dp[i]);

        System.out.println(result);
    }
}