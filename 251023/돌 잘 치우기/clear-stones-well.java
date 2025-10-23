import java.util.*;

public class Main {
    private static final int MAX_NUM = 100;
    private static int n, k, m;
    private static int[][] grid;
    private static boolean[][] visited;
    private static Queue<Point> q;
    private static ArrayList<Point> stone;
    private static ArrayList<Point> pick;

    private static int[][] startPoints = new int[MAX_NUM*MAX_NUM+1][2];

    private static int result = 0;

    static class Point{
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void initialize() {
        q = new LinkedList<>();
        visited = new boolean[MAX_NUM+1][MAX_NUM+1];
    }

    private static boolean canGo(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;
        
        if(visited[x][y])
            return false;

        return true;
    }

    private static int move() {
        int[][] newGrid = new int[n][n];
        for (int i = 0; i < n; i++) {
            newGrid[i] = grid[i].clone();
        }

        for(int i=0; i<pick.size(); i++) {
            Point pickStone = pick.get(i);
            newGrid[pickStone.x][pickStone.y] = 0;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int sum = 0;
        for(int i=0; i<k; i++) {

            int cnt = 1;
            int startX = startPoints[i][0];
            int startY = startPoints[i][1];

            q.add(new Point(startX, startY));
            visited[startX][startY] = true;

            while(!q.isEmpty()) {
                Point p = q.poll();
                int thisX = p.x;
                int thisY = p.y;

                for(int dir=0; dir<4; dir++) {
                    int newX = thisX + dx[dir];
                    int newY = thisY + dy[dir];
                    if(canGo(newX, newY) && newGrid[newX][newY] != 1) {
                        cnt++;
                        visited[newX][newY] = true;
                        q.add(new Point(newX, newY));
                    }
                }
            }
            sum += cnt;
        }
        

        return sum;
    }

    private static void solution(int cnt) {
        if(cnt == m) {
            int distance = move();

            initialize();

            result = Math.max(result, distance);

            return;
        }
        
        for(int i=0; i<stone.size(); i++) {
            pick.add(stone.get(i));
            solution(cnt + 1);
            pick.remove(pick.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];

        q = new LinkedList<>();
        stone = new ArrayList<>();
        pick = new ArrayList<>();
        visited = new boolean[MAX_NUM+1][MAX_NUM+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1)
                    stone.add(new Point(i, j));
            }
        }

        startPoints = new int[k][2];
        for (int i = 0; i < k; i++) {
            startPoints[i][0] = sc.nextInt() - 1;
            startPoints[i][1] = sc.nextInt() - 1;
        }

        solution(0);

        System.out.println(--result);
    }
}