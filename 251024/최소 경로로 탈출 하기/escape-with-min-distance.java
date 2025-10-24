import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;
    private static int m, n;
    private static int[][] grid, dist;
    private static boolean[][] visited = new boolean[MAX_NUM+1][MAX_NUM+1];
    private static Queue<Point> q;

    private static class Point {
        int x;
        int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m)
            return false;
        
        if(visited[x][y])
            return false;

        if(grid[x][y] == 0)
            return false;
        
        return true;

    }

    private static void solution(int startX, int startY) {
        q.add(new Point(startX, startY));
        visited[startX][startY] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            Point p = q.poll();
            int currX = p.x, currY = p.y;

            for(int dir = 0; dir<4; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];

                if(canGo(newX, newY)) {
                    dist[newX][newY] = dist[currX][currY] + 1;
                    visited[newX][newY] = true;
                    q.add(new Point(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        dist = new int[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        solution(0, 0);

        int result = dist[n-1][m-1] == 0 ? -1: dist[n-1][m-1];
        System.out.println(result);
    }
}