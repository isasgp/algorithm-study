import java.util.*;

public class Main {
    private static final int MAX_NUM = 20;
    private static final int LIMIT = 3;

    private static int n;
    private static int[][] grid = new int[MAX_NUM][MAX_NUM];
    private static boolean[][] isVisited = new boolean[MAX_NUM+1][MAX_NUM+1];

    private static ArrayList<Integer> arr;
    private static ArrayList<Point> bomb;

    private static int result = 0;

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void clearVisit() {
        for(int i=0; i<=MAX_NUM; i++)
            for(int j=0; j<=MAX_NUM; j++)
                isVisited[i][j] = false;
    }

    private static boolean canAttack(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;

        if(isVisited[x][y])
            return false;
        
        return true;
    }

    private static int doAttack(int type, int x, int y) {
        int[] dx;
        int[] dy;

        if(type == 1) {
            dx = new int[] {-2, -1, 0, 1, 2};
            dy = new int[] {0, 0, 0, 0, 0};
        } else if(type == 2) {
            dx = new int[] {0, 0, 1, 0, -1};
            dy = new int[] {0, -1, 0, 1, 0};
        } else if(type == 3) {
            dx = new int[] {0, -1, -1, 1, 1};
            dy = new int[] {0, -1, 1, -1, 1};
        } else {
            return 0;
        }

        int cnt = 0;

        for(int i=0; i<5; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(canAttack(newX, newY)) {
                isVisited[newX][newY] = true;
                cnt++;
            }
        }
        return cnt;
    }

    private static void solution(int currNum) {
        if(currNum == bomb.size()) {
            int currCnt = 0;
            for(int i=0; i<arr.size(); i++) {
                // System.out.println(arr.get(i)+" "+bomb.get(i).x+" "+bomb.get(i).y);
                currCnt += doAttack(arr.get(i), bomb.get(i).x, bomb.get(i).y);
            }
            result = Math.max(result, currCnt);
            clearVisit();

            // System.out.println(currCnt);
            // System.out.println();
            return;
        }

        for(int i=1; i<=LIMIT; i++) {
            arr.add(i);
            solution(currNum + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new ArrayList<>();
        bomb = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    bomb.add(new Point(i, j));
                }
            }
        }

        solution(0);
        System.out.println(result);
    }
}