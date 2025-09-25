import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;
    private static int n, m;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_NUM+1][MAX_NUM+1];
    private static int result = 0;

    private static boolean canGo(int x, int y) {
        if(x<0 || x>n-1 || y<0 || y>m-1)
            return false;
        
        if(grid[x][y] == 0)
            return false;

        if(visited[x][y] == 1)
            return false;

        return true;
    }
    private static void DFS(int x, int y) {
        if(x == n-1 && y == m-1) 
            result = 1;
        int[] dx = {1, 0};
        int[] dy = {0, 1};

        for(int i=0; i<2; i++) {
            int newX = x+dx[i];
            int newY = y+dy[i];
            if(canGo(newX, newY)) {
                visited[newX][newY] = 1;
                DFS(newX, newY);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        
        if(grid[0][0] == 1) {
            visited[0][0] = 1;
            DFS(0, 0);
        }


        System.out.println(result);
    }
}