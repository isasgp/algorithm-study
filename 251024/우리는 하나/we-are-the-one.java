import java.util.*;

public class Main {
    private static final int MAX_NUM = 8;

    private static int n, k, u, d;
    private static int[][] grid;
    private static boolean[][] visited;
    private static ArrayList<Point> arr, pick;
    private static Queue<Point> q;

    private static int result = 0;

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

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;

        if(visited[x][y])
            return false;

        return true;
    }

    public static void choose(int cnt, int idx) {
        if(cnt == k) {
            int val = 0;
            initializeVisited();
            for(int i=0; i<k; i++) {
                Point p = pick.get(i);
                q.add(new Point(p.x, p.y));
                visited[p.x][p.y] = true;

                val += solution();
            }

            result = Math.max(result, val);

            q.clear();
            return;
        }

        for(int i=idx; i<arr.size(); i++) {
            pick.add(arr.get(i));
            choose(cnt + 1, i + 1);
            pick.remove(pick.size() - 1);
        }
    }

    private static int solution() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int cnt = 1;

        while(!q.isEmpty()) {
            Point p = q.poll();
            int currX = p.x, currY = p.y;
            for(int dir=0; dir<4; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];
                if(canGo(newX, newY)) {
                    int distance = Math.abs(grid[newX][newY] - grid[currX][currY]);
                    if(distance < u || distance > d)
                        continue;
                    
                    cnt++;
                    visited[newX][newY] = true;
                    q.add(new Point(newX, newY));
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        grid = new int[n][n];
        arr = new ArrayList<>();
        pick = new ArrayList<>();
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                arr.add(new Point(i, j));
            }
        }

        choose(0, 0);

        System.out.println(result);
    }
}