import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;
    private static int n;
    private static int[][] matrix, dp;

    private static void solution() {
        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        matrix = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = matrix[0][0];
        for(int i=1; i<n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        solution();

        System.out.println(dp[n - 1][n - 1]);
    }
}