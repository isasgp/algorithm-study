import java.util.*;

public class Main {
    private static final int MAX_SIZE = 100;
    private static final int MAX_NUM = 100;

    private static int n;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_SIZE+1][MAX_SIZE+1];

    private static void cleanVisit() {
        for(int i=0; i<=MAX_SIZE; i++) {
            for(int j=0; j<=MAX_SIZE; j++) {
                visited[i][j] = 0;
            }
        }
    }

    private static boolean canGo(int x, int y, int num) {
        if(x<0 || x>=n || y<0 || y>=n)
            return false;

        if(visited[x][y] == 1)
            return false;

        if(grid[x][y] != num)
            return false;

        return true;
    }

    private static int solution(int x, int y, int num) {
        int cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(canGo(newX, newY, num)) {
                visited[newX][newY] = 1;
                cnt++;
                cnt += solution(newX, newY, num);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];

        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                maxNum = Math.max(maxNum, grid[i][j]);
            }
                
        int resultCnt = 0;
        int resultMax = 0;
        for(int num=1; num<=maxNum; num++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(visited[i][j] == 1 || grid[i][j] != num)
                        continue;

                    visited[i][j] = 1;
                    int val = solution(i, j, num)+1;
                    resultMax = Math.max(resultMax, val);
                    if(val >= 4)
                        resultCnt++;

                }
            }
            // cleanVisit();
        }
        System.out.println(resultCnt + " " + resultMax);

        // Please write your code here.
    }
}