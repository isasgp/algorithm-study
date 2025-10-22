import java.util.*;

public class Main {
    private static final int MAX_NUM = 10;

    private static int m, n, c;
    private static int[][] grid;
    private static int maxVal;

    private static boolean inRange(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= n);
    }
    private static boolean possible(int x1, int y1, int x2, int y2) {
        if(!inRange(x1, y1) || !inRange(x2, y2))
            return false;

        if(y1 + m - 1 >= n || y2 + m - 1 >= n)
            return false;
        
        if(x1 != x2)
            return true;

        if((y1 >= y2 && y1 <= y2 + m - 1) || (y1 + m - 1 >= y2 && y1 <= y2))
            return false;

        return true;
    }

    private static void solution(int x, int y, int cnt, int currWeight, int currValue) {
        if(cnt == m) {
            maxVal = Math.max(maxVal, currValue);
            return;
        }

        solution(x, y+1, cnt + 1, currWeight, currValue);

        int thisWeight = grid[x][y];

        if(currWeight + thisWeight <= c) {
            int thisValue = thisWeight * thisWeight;
            solution(x, y+1, cnt + 1, currWeight + thisWeight, currValue + thisValue);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        int result = 0;

        for(int x1=0; x1<n; x1++) {
            for(int y1=0; y1<n; y1++) {
                for(int x2=0; x2<n; x2++) {
                    for(int y2=0; y2<n; y2++) {
                        if(possible(x1, y1, x2, y2)) {
                            maxVal = 0;
                            solution(x1, y1, 0, 0, 0);
                            int firstVal = maxVal;

                            maxVal = 0;
                            solution(x2, y2, 0, 0, 0);
                            int secondVal = maxVal;

                            result = Math.max(result, firstVal + secondVal);
                        }
                    }
                }
            }
        }

        System.out.println(result);
    }
}