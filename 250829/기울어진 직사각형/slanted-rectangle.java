import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int[][] grid;

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    private static int solution(int x, int y, int k, int l) {
        int[] dx = {1, -1, -1, 1};
        int[] dy = {1, 1, -1, -1};
        int[] moveNum = {k, l, k, l};

        if((k+l)*2 > (N-1)*2) return 0;

        int sum = 0;

        for(int direction=0; direction<4; direction++) {
            for(int i=0; i<moveNum[direction]; i++) {
                x += dx[direction];
                y += dy[direction];

                if(!inRange(x, y)) return 0;

                sum += grid[x][y];
            }
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                for(int k = 1; k < N; k++)
                    for(int l = 1; l < N; l++)
                        ans = Math.max(ans, solution(i, j, k, l));

        System.out.println(ans);


    }
}