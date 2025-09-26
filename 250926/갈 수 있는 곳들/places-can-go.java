import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;

    private static int n, k;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_NUM+1][MAX_NUM+1];
    private static Queue<Point> q;
    private static int cnt = 0;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean canGo(int x, int y) {
        if(x<0 || x>=n || y<0 || y>=n)
            return false;

        if(visited[x][y] == 1)
            return false;

        if(grid[x][y] == 1)
            return false;

        return true;
    }

    private static void solution() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {
            Point curr = q.poll();
            int x = curr.x, y = curr.y;
            for(int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(canGo(newX, newY)) {
                    visited[newX][newY] = 1;
                    cnt++;
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
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        q = new LinkedList<>();

        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt()-1;
            starts[i][1] = sc.nextInt()-1;
        }

        for(int i=0; i<k; i++) {
            Point p = new Point(starts[i][0], starts[i][1]);
            if(grid[p.x][p.y] == 1 || visited[p.x][p.y] == 1)
                continue;
            
            visited[p.x][p.y] = 1;
            cnt++;
            q.add(p);
            solution();
        }

        System.out.println(cnt);
    }
}