import java.util.*;
public class Main {
    private static final int MAX_NUM = 100;
    private static int n, k, r, c;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_NUM+1][MAX_NUM+1];
    private static Queue<Point> q;
    private static ArrayList<Point> arr;

    static class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void cleanVisited() {
        for(int i=0; i<=MAX_NUM; i++)
            for(int j=0; j<=MAX_NUM; j++)
                visited[i][j] = 0;
    }

    private static void arrSort() {
        arr.sort((p1, p2) -> {
            if(p1.x != p2.x) {
                return Integer.compare(p1.x, p2.x);
            }
            return Integer.compare(p1.y, p2.y);
        });
    }

    private static boolean canGo(int x, int y) {
        if(x<0 || x>=n || y<0 || y>=n)
            return false;

        if(visited[x][y] == 1 || grid[x][y] >= grid[r][c])
            return false;

        return true;
    }

    private static void solution() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int maxVal = 0;

        while(!q.isEmpty()) {
            Point curr = q.poll();
            int x = curr.x, y = curr.y;

            for(int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(canGo(newX, newY)) {
                    if(maxVal < grid[newX][newY]) {
                        maxVal = grid[newX][newY];
                        arr.clear();
                        arr.add(new Point(newX, newY));
                    } else if(maxVal == grid[newX][newY]) {
                        arr.add(new Point(newX, newY));
                    }
                    visited[newX][newY] = 1;
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
        q = new LinkedList<>();
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        

        for(int i=0; i<k; i++) {
            arr.clear();

            q.add(new Point(r, c));
            visited[r][c] = 1;
            solution();
            arrSort();

            if(arr.isEmpty()) 
                break;

            Point newPoint = arr.get(0);
            r = newPoint.x;
            c = newPoint.y;
            // System.out.println((i+1)+"번 실행한 결과"+ r+" "+c);
            cleanVisited();
        }
        System.out.println((r+1)+" "+(c+1));
    }
}