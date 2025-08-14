import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int solution(int x, int y) {
        if(x+2 > n || y+2 > n) {return 0;}
        int cnt = 0;
        for(int i=x; i<x+3; i++) {
            for(int j=y; j<y+3; j++) {
                cnt += arr[i][j];
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        input();

        int max = Integer.MIN_VALUE;

        for(int i=0; i<n-2; i++) {
            for(int j=0; j<n-2; j++) {
                int result = solution(i, j);
                max = result > max ? result: max;
            }
        }

        System.out.println(max);
    }
}