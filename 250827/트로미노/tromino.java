import java.util.*;
import java.io.*;

public class Main {

    private final static int MAX_NUM = 200;
    private static int N, M;
    private static int[][] grid;

    private static int[][][] shapes = {
        {
            {1,1,1},
            {0,0,0},
            {0,0,0}
        },
        {
            {1,0,0},
            {1,0,0},
            {1,0,0}
        },
        {
            {1,1,0},
            {1,0,0},
            {0,0,0}
        },
        {
            {1,1,0},
            {0,1,0},
            {0,0,0}
        },
        {
            {0,1,0},
            {1,1,0},
            {0,0,0}
        },
        {
            {1,0,0},
            {1,1,0},
            {0,0,0}
        }
    };

    public static int solution(int x, int y) {
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i<6; i++) {
            boolean isPossible = true;
            int sum = 0;

            for(int dx=0; dx<3; dx++) {
                for(int dy=0; dy<3; dy++) {
                    if(shapes[i][dx][dy] == 0) continue;

                    if(x+dx >= N || y+dy >= M) isPossible = false;
                    else sum += grid[x+dx][y+dy];
                }
            }
            if(isPossible) maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N > MAX_NUM || M > MAX_NUM) {
            System.out.println("Input Error");
            return;
        }

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, solution(i, j));
            }
        }
        System.out.println(result);
    }
}