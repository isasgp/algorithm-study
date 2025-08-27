import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[][] grid;

    private static int fee(int k) {
        return (int)(Math.pow(k,2) + Math.pow(k+1, 2));
    }

    private static int solution(int x, int y, int k) {
        int gold = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(Math.abs(x-i)+Math.abs(y-j) <= k) {
                    gold += grid[i][j];
                }
            }
        }
        return gold;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for(int x=0; x<N; x++) {
            for(int y=0; y<N; y++) {
                for(int k=0; k<= 2*N-2; k++) {
                    int numGold = solution(x, y, k);
                    if(numGold * M > fee(k)) {
                        result = Math.max(result, numGold);
                    }
                }
            }
        }
        System.out.println(result);
    }
}