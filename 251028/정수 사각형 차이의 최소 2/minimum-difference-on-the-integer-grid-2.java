import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int MAX_NUM = 100;

    private static int n;
    private static int[][] grid, dp;

    private static void printArr(int[][] dp) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void initialize() {
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                dp[i][j] = INT_MAX;

        dp[0][0] = grid[0][0];

        for(int i=1; i<n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], grid[i][0]);
            dp[0][i] = Math.max(dp[0][i - 1], grid[0][i]);
        }
    }

    private static int solution(int lowerBound) {
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(grid[i][j] < lowerBound)
                    grid[i][j] = INT_MAX;

        initialize();

        for(int i=1; i<n; i++) {
            for(int j=1; j<n; j++) {
                int thisVal = grid[i][j];
                dp[i][j] = Math.max(Math.min(dp[i-1][j], dp[i][j-1]), thisVal);
            }
        }

        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int result = INT_MAX;

        for(int lowerBound=1; lowerBound<=MAX_NUM; lowerBound++) {
            int upperBound = solution(lowerBound);

            if(upperBound == INT_MAX)
                continue;
            
            result = Math.min(result, upperBound - lowerBound);

        }

        System.out.println(result);
    }
}