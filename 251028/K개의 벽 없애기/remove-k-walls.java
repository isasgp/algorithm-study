import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;
    private static final int INT_MAX = Integer.MAX_VALUE;

    private static int n, k, r1, c1, r2, c2;
    private static int[][] grid, dist;
    private static boolean[][] visited;
    private static ArrayList<Point> arr, wall;
    private static Queue<Point> q;

    private static int result = INT_MAX;

    private static class Point {
        int x;
        int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void initialize() {
        dist = new int[n][n];
        visited = new boolean[MAX_NUM][MAX_NUM];
        q.clear();
    }

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        
        if(visited[x][y])
            return false;

        return true;
    }

    private static int findDist() {
        int[][] newGrid = new int[n][n];
        for(int i=0; i<n; i++)
            newGrid[i] = grid[i].clone();
        
        for(int i=0; i<arr.size(); i++) {
            Point p = arr.get(i);
            newGrid[p.x][p.y] = 0;
        }

        q.add(new Point(r1, c1));
        visited[r1][c1] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean isFind = false;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int currX = p.x, currY = p.y;
            for(int dir=0; dir<4; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];
                if(canGo(newX, newY) && newGrid[newX][newY] == 0) {
                    dist[newX][newY] = dist[currX][currY] + 1;
                    visited[newX][newY] = true;

                    if(newX == r2 && newY == c2) {
                        isFind = true;
                        break;
                    }

                    q.add(new Point(newX, newY));
                }
            }
            if(isFind)
                break;
        }
        if(dist[r2][c2] == 0)
            return INT_MAX;

        return dist[r2][c2];
    }

    private static void solution(int cnt, int index) {
        if(cnt == k) {
            initialize();
            int thisVal = findDist();
            result = Math.min(result, thisVal);

            return;
        }

        for(int i=index; i<wall.size(); i++) {
            arr.add(wall.get(i));
            solution(cnt + 1, index + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];
        arr = new ArrayList<>();
        wall = new ArrayList<>();
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1)
                    wall.add(new Point(i, j));
            }
        }
        r1 = sc.nextInt() - 1;
        c1 = sc.nextInt() - 1;
        r2 = sc.nextInt() - 1;
        c2 = sc.nextInt() - 1;
        
        solution(0, 0);

        if(result == INT_MAX)
            result = -1;
        
        System.out.println(result);
    }
}