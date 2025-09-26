import java.util.*;

public class Main {
    private static final int MAX_NUM = 50;
    private static final int MAX_HOUSE = 100;

    private static int n, m;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_NUM+1][MAX_NUM+1];
    private static ArrayList<Integer>[] result = new ArrayList[MAX_HOUSE+1];

    private static void cleanVisit() {
        for(int i=0; i<MAX_NUM+1; i++)
            for(int j=0; j<MAX_NUM+1; j++)
                visited[i][j] = 0;
    }

    private static boolean canGo(int x, int y, int k) {
        if(x<0 || x>=n || y<0 || y>=m)
            return false;

        if(visited[x][y] == 1)
            return false;

        if(grid[x][y] <= k)
            return false;

        return true;
    }

    private static int solution(int x, int y, int k) {
        int cnt = 0;
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(canGo(newX, newY, k)) {
                visited[newX][newY] = 1;
                cnt++;
                cnt += solution(newX, newY, k);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        int maxK = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
                maxK = Math.max(maxK, grid[i][j]);
            }
        }
        
        for(int i=0; i<=MAX_HOUSE; i++)
            result[i] = new ArrayList<>();

        for(int k=1; k<=maxK; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] == 1 || grid[i][j] <= k)
                        continue;

                    visited[i][j] = 1;
                    result[k].add(solution(i, j, k));
                }
            }
            cleanVisit();
        }

        int resultIdx = Integer.MIN_VALUE;
        int resultVal = Integer.MIN_VALUE;
        for(int k=1; k<=maxK; k++) {
            if(resultVal < result[k].size()) {
                resultIdx = k;
                resultVal = result[k].size();
            } 
        }
        System.out.println(resultIdx+" "+resultVal);
    }
}