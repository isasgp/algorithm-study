import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;

    private static int n, m;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_NUM+1][MAX_NUM+1];
    private static Queue<Point> q;

    private static int possible = 0;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static boolean canGo(int x, int y) {
        if(x<0 || x>=n || y<0 || y>= m)
            return false;
        
        if(visited[x][y] == 1)
            return false;

        if(grid[x][y] == 0)
            return false;

        return true;
    }

    private static void solution() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            Point curr = q.poll();
            int x = curr.x, y = curr.y;

            if(x == n-1 && y == m-1)
                possible = 1;

            for(int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(canGo(newX, newY)) {
                    visited[newX][newY] = 1;
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
        q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();

        if(grid[0][0] == 1) {
            q.add(new Point(0,0));
            visited[0][0] = 1;
            solution();
        } 

        System.out.println(possible);
    }
}