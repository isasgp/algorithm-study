import java.util.Scanner;
public class Main {
    private static int n;
    private static int[][] grid, dp;

    private static int solution() {
        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = Math.max(Math.min(dp[i - 1][j], dp[i][j - 1]), grid[i][j]);
            }
        }
        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = grid[0][0];
        for(int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], grid[i][0]);
            dp[0][i] = Math.max(dp[0][i - 1], grid[0][i]);
        }

        int result = solution();
        System.out.println(result);
    }
}