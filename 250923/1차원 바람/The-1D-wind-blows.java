import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, Q;
    private static int[][] grid;

    private static boolean isPropagation(int x, int x1) {
        if(x1 < 0 || x1 > N-1)
            return false;
        for(int i=0; i<M; i++) {
            if(grid[x][i] == grid[x1][i])
                return true;
        }
        return false;
    }

    private static void shiftRight(int r, boolean isUp, boolean isDown) {
        int temp = grid[r][M-1];
        for(int i=M-1; i>0; i--) {
            grid[r][i] = grid[r][i-1];
        }
        grid[r][0] = temp;

        // 윗쪽 방향
        if(isPropagation(r, r-1) && isUp)
            shiftLeft(r-1, true, false);

        // 아래쪽 방향
        if(isPropagation(r, r+1) && isDown)
            shiftLeft(r+1, false, true);

    }

    private static void shiftLeft(int r, boolean isUp, boolean isDown) {
        int temp = grid[r][0];
        for(int i=0; i<M-1; i++) {
            grid[r][i] = grid[r][i+1];
        }
        grid[r][M-1] = temp;

        // 윗쪽 방향
        if(isPropagation(r, r-1) && isUp)
            shiftRight(r-1, true, false);

        // 아래쪽 방향
        if(isPropagation(r, r+1) && isDown)
            shiftRight(r+1, false, true);

    }
        

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                grid[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int d = st.nextToken().charAt(0);

            if(d == 'L')
                shiftRight(r-1, true, true);

            if(d == 'R')
                shiftLeft(r-1, true, true);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }
}