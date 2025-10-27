import java.util.*;

public class Main {
    private static int n;
    private static int[][] grid, dp;
    private static ArrayList<Point> arr;

    private static class Point {
        int val;
        int x;
        int y;

        private Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    private static boolean inRange(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= n);
    }

    private static void solution() {
        int[] dx = {-1, 1, 0 ,0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<arr.size(); i++) {
            Point p = arr.get(i);
            int currX = p.x, currY = p.y;
            for(int dir=0; dir<4; dir++) {
                int newX = currX + dx[dir];
                int newY = currY + dy[dir];
                if(inRange(newX, newY) && grid[newX][newY] > grid[currX][currY]) {
                    dp[newX][newY] = Math.max(dp[newX][newY], dp[currX][currY] + 1);       
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        dp = new int[n][n];
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                arr.add(new Point(grid[i][j], i, j));
            }
        }

        arr.sort((o1, o2) -> o1.val - o2.val);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }

        solution();

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, dp[i][j]);
            }
        }
        System.out.println(result);
    }
}