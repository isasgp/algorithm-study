import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;

    private static int n;
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
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        if(visited[x][y])
            return false;
        return true;
    }

    private static int solution(int startX, int startY, int endX, int endY) {
        if(startX == endX && startY == endY)
            return 0;

        q.add(new Point(startX, startY));
        visited[startX][startY] = true;

        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        int distance = -1;
        boolean isFind = false;
        while(!q.isEmpty()) {
            Point p = q.poll();
            int currX = p.x, currY = p.y;

            for(int dir=0; dir<8; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];
                if(canGo(newX, newY)) {
                    visited[newX][newY] = true;
                    
                    dist[newX][newY] = dist[currX][currY] + 1;

                    if(endX == newX && endY == newY) {
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

        return distance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        grid = new int[n][n];
        dist = new int[n][n];
        q = new LinkedList<>();

        int r1 = sc.nextInt() - 1;
        int c1 = sc.nextInt() - 1;
        int r2 = sc.nextInt() - 1;
        int c2 = sc.nextInt() - 1;
        
        int result = solution(r1, c1, r2, c2);

        System.out.println(result);
    }
}