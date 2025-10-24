import java.util.*;

public class Main {
    private static final int MAX_NUM = 200;
    private static int n, m;
    private static int[][] grid;
    private static boolean[][] visited = new boolean[MAX_NUM+1][MAX_NUM+1];
    private static Queue<Point> q;

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void initializeVisited() {
        visited = new boolean[MAX_NUM+1][MAX_NUM+1];
    }

    private static int countGlacier() {
        int cnt = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if(grid[i][j] == 1)
                    cnt++;

        return cnt;
    }

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= m)
            return false;
        
        if(visited[x][y])
            return false;

        return true;
    }

    private static boolean canStart(int x, int y) {
        if(grid[x][y] == 1)
            return false;
        
        if(visited[x][y])
            return false;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[] isPossible = new boolean[4];

        for(int dir=0; dir<4; dir++) {
            int newX = x + dx[dir];
            int newY = y + dy[dir];
            
            if(newX < 0 || newX >= n || newY < 0 || newY >= m)
                return true;

            if(grid[newX][newY] == 0)
                isPossible[dir] = true;
        }

        return isPossible[0] || isPossible[1] || isPossible[2] || isPossible[3];
    }

    private static void solution() {
        int[][] newGrid = new int[n][m];
        for(int i=0; i<n; i++) {
            newGrid[i] = grid[i].clone();
        }

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
                    if(grid[newX][newY] == 1) {
                        newGrid[newX][newY] = 0;
                    } else {
                        q.add(new Point(newX, newY));
                    }
                }
            }
        }
        grid = newGrid;
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

        int time = 0;
        int beforeCnt = 0;

        for(int t=1; t<10; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(canStart(i, j)) {
                        q.add(new Point(i, j));
                        visited[i][j] = true;
                    }
                }
            }
            
            beforeCnt = countGlacier();

            solution();

            if(countGlacier() == 0) {
                time = t;
                break;
            }

            initializeVisited();
        }
        
        System.out.println(time+" "+beforeCnt);
    }
}