import java.util.Scanner;
public class Main {
    // private static class Line {
    //     int start;
    //     int end;
    //     private Line(int start, int end) {
    //         this.start = start;
    //         this.end = end;
    //     }
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] segments = new int[n][2];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            segments[i][0] = sc.nextInt();
            segments[i][1] = sc.nextInt();
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(segments[j][0] > segments[i][1] ||
                segments[j][1] < segments[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) 
            result = Math.max(result, dp[i]);
        
        System.out.println(++result);
    }
}