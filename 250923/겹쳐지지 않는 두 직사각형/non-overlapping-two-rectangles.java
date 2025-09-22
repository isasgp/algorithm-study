import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] grid;

    private static int calculateSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int x=x1; x<=x2; x++) {
            for(int y=y1; y<=y2; y++) {
                sum += grid[x][y];
            }
        }
        return sum;
    }

    private static boolean isOverlap(
        int x1,
        int y1,
        int x2,
        int y2,
        int x3,
        int y3,
        int x4,
        int y4) {
            if(x2 < x3) return false;
            if(x1 > x4) return false;
            if(y1 > y4) return false;
            if(y2 < y3) return false;
            return true;
        }

    private static int solution(int x1, int y1) {
        int maxSum = Integer.MIN_VALUE;

        // 첫번째 사각형
        for(int x2=x1; x2<N; x2++) {
            for(int y2=y1; y2<M; y2++) {

                // 두번째 사각형
                for(int x3=0; x3<N; x3++) {
                    for(int y3=0; y3<M; y3++) {
                        for(int x4=x3; x4<N; x4++) {
                            for(int y4=y3; y4<M; y4++) {
                                if(isOverlap(x1, y1, x2, y2, x3, y3, x4, y4))
                                    continue;

                                maxSum = Math.max(maxSum,calculateSum(x1, y1, x2, y2) + calculateSum(x3, y3, x4, y4));
                            }
                        }
                    }
                }
            }
        }

        return maxSum;
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for(int x=0; x<N; x++) {
            for(int y=0; y<M; y++) {
                result = Math.max(solution(x, y), result); 
            }
        }

        System.out.println(result);
    }
}