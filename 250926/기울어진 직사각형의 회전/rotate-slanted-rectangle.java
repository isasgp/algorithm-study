import java.util.*;

public class Main {
    private static int n, r, c, m1, m2, m3, m4, dir;
    private static int[][] grid;
    
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void rotateGrid(int x, int y, int m1, int m2, int dir) {
        int recLenth = 2* (m1 + m2);

        Point[] gridPoint = new Point[recLenth];
        
        int[] dx = new int[4], dy = new int[4];

        dx = new int[]{-1, -1, 1, 1};
        dy = new int[]{1, -1, -1, 1};

        
        int[] length = {m1, m2, m1, m2};

        int xPoint = x;
        int yPoint = y;
        int idx = 0;

        for(int i=0; i<4; i++) {
            for(int j=0; j<length[i]; j++) {
                gridPoint[idx++] = new Point(xPoint, yPoint);
                xPoint += dx[i];
                yPoint += dy[i];
            }
        }

        

        if(dir == 0) {
            int tempValue = grid[gridPoint[recLenth-1].x][gridPoint[recLenth-1].y];
            for(int i=recLenth-1; i>0; i--) {
                grid[gridPoint[i].x][gridPoint[i].y] = grid[gridPoint[i-1].x][gridPoint[i-1].y];
            }
            grid[gridPoint[0].x][gridPoint[0].y] = tempValue;

        } else if(dir == 1) {
            int tempValue = grid[gridPoint[0].x][gridPoint[0].y];
            for(int i=0; i<recLenth-1; i++) {
                grid[gridPoint[i].x][gridPoint[i].y] = grid[gridPoint[i+1].x][gridPoint[i+1].y];
            }
            grid[gridPoint[recLenth-1].x][gridPoint[recLenth-1].y] = tempValue;
        } else {
            return;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        m1 = sc.nextInt();
        m2 = sc.nextInt();
        m3 = sc.nextInt();
        m4 = sc.nextInt();
        dir = sc.nextInt();

        rotateGrid(r-1, c-1, m1, m2, dir);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }

    }
}