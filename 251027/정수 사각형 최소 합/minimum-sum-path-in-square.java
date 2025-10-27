import java.util.*;

public class Main {
    private static int n;
    private static int[][] matrix, dp;

    private static void solution() {
       
        for(int i=1; i<n; i++) {
            for(int j=n-2; j>=0; j--) {
                dp[i][j] = Math.min(dp[i-1][j] + matrix[i][j], dp[i][j+1] + matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        dp[0][n-1] = matrix[0][n-1];

        for(int i=n-2; i>=0; i--) {
            dp[0][i] = dp[0][i+1] + matrix[0][i];
        }
        for(int i=1; i<n; i++) {
            dp[i][n-1] = dp[i-1][n-1] + matrix[i][n-1];
        }


        solution();

        System.out.println(dp[n-1][0]);
    }
}