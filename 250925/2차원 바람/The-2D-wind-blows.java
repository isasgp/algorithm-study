import java.util.*;

public class Main {
    private static int n, m, q;
    private static int[][] building;

    private static void clockShift(int x1, int y1, int x2, int y2) {
        int temp = building[x1][y1];

        for(int i=x1; i<x2; i++) {
            building[i][y1] = building[i+1][y1]; 
        }

        for(int j=y1; j<y2; j++) {
            building[x2][j] = building[x2][j+1]; 
        }

        for(int i=x2; i>x1; i--) {
            building[i][y2] = building[i-1][y2]; 
        }

        for(int j=y2; j>y1; j--) {
            building[x1][j] = building[x1][j-1]; 
        }

        building[x1][y1+1] = temp;
    }

    private static int caculateValue(int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int count = 1;
        int sum = building[x][y];

        for(int i=0; i<4; i++) {
            if(x+dx[i] < 0 || x+dx[i] > n-1 || y+dy[i] < 0 || y+dy[i] > m-1) continue;
            sum += building[x+dx[i]][y+dy[i]];
            count++;
        }
        return sum/count;
    }

    private static void solution(int x1, int y1, int x2, int y2) {
        clockShift(x1, y1, x2, y2);
        int[][] temp = new int[x2+1][y2+1];

        for(int i=x1; i<=x2; i++) 
            for(int j=y1; j<=y2; j++) 
                temp[i][j] = caculateValue(i, j);
        
        for(int i=x1; i<=x2; i++)
            for(int j=y1; j<=y2; j++) 
                building[i][j] = temp[i][j];
            
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        building = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();

        int[][] queries = new int[q][4];

        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt() - 1;

        for(int i=0; i<q; i++) {
            solution(queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(building[i][j]+" ");
            System.out.println();
        }
        
    }
}