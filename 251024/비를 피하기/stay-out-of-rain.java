import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;

    private static int n, h, m;
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
        visited = new boolean[MAX_NUM+1][MAX_NUM+1];
        dist = new int[n][n];
    }

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;

        if(visited[x][y])
            return false;
        
        if(grid[x][y] == 1)
            return false;

        return true;
    }

    private static int solution(int x, int y) {
        q.add(new Point(x, y));
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int distance = -1;
        boolean isFind = false;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int currX = p.x, currY = p.y;

            for(int dir=0; dir<4; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];

                if(canGo(newX, newY)) {
                    visited[newX][newY] = true;
                    dist[newX][newY] = dist[currX][currY] + 1;
                    if(grid[newX][newY] == 3) {
                        distance = dist[newX][newY];
                        isFind = true;
                        break;
                    }
                    q.add(new Point(newX, newY));
                }
            }
            if(isFind)
                break;
        }
        q.clear();
        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        q = new LinkedList<>();

        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2)
                    arr.add(new Point(i, j));    
            }
        }

        int[][] result = new int[n][n];

        for(int i=0; i<arr.size(); i++) {
            initialize();

            Point p = arr.get(i);

            int currX = p.x, currY = p.y;
            int distance = solution(currX, currY);
            result[currX][currY] = distance;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}