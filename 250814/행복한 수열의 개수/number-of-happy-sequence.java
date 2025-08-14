import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static boolean isHappy(int[] a) {
        
        int same = 1;
        for(int i=1; i<a.length; i++) {
            if(a[i] == a[i-1])  same++;
            else    same = 1;

            if(same >= m)   return true;
        }

        return m <= 1;
    }

    public static int solution() {
        int cnt = 0;

        for(int i=0; i<n; i++) {
            if(isHappy(arr[i])) cnt++;
        }


        for(int i=0; i<n; i++) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                temp[j] = arr[j][i];
            }
            if(isHappy(temp))    cnt++;
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solution());
    }
}