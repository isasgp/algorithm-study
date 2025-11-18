import java.util.Scanner;
public class Main {
    private static final int INT_MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
    
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                dp[i][j] = INT_MIN;
        dp[0][0] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for(int a = 0; a < i; a++) {
                    for(int b = 0; b < j; b++) {
                        if(dp[a][b] == INT_MIN)
                            continue;
                        
                        if(grid[i][j] > grid[a][b]) {  
                            dp[i][j] = Math.max(dp[i][j], dp[a][b] + 1);
                        }
                            
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}