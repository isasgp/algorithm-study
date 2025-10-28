import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;

    private static int n, k;
    private static int[][] grid, dist;
    private static boolean[][] visited;
    private static Queue<Point> q;

    private static class Point {
        int x;
        int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void initialize() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    dist[i][j] = -1;
                }
            }
        }
    }

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        if(visited[x][y])
            return false;
        if(grid[x][y] == 0)
            return false;
        return true;
    }

    private static void solution() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            Point p = q.poll();
            int currX = p.x, currY = p.y;
            for(int dir=0; dir<4; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];

                if(canGo(newX, newY)) {
                    visited[newX][newY] = true;
                    dist[newX][newY] = dist[currX][currY] + 1;
                    grid[newX][newY] = 2;

                    q.add(new Point(newX, newY));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        dist = new int[n][n];
        visited = new boolean[n][n];
        q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();

                if(grid[i][j] == 2) {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        initialize();
        
        solution();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dist[i][j] = -2;
                }
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
                
    }
}