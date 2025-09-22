import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] grid;

    private static int calculateCount(int x1, int y1, int x2, int y2) {
        int count = 0;
        for(int i=x1; i<=x2; i++){
            for(int j=y1; j<=y2; j++) {
                if(grid[i][j] < 0)
                    return -1;
                count++;
            }
        }
        
        return count;
    }

    private static int solution(int x1, int y1) {
        if(grid[x1][y1] < 0)
            return -1;

        int maxSize = Integer.MIN_VALUE;
        for(int x2=x1; x2<N; x2++) {
            for(int y2=y1; y2<M; y2++) {
                if(grid[x2][y2] < 0)
                    break;
                maxSize = Math.max(maxSize, calculateCount(x1, y1, x2, y2));
            }
        }
        return maxSize;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.MIN_VALUE;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                result = Math.max(result, solution(i, j));
        }

        System.out.println(result);

    }
}