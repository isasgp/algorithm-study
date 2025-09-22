import java.util.*;
import java.io.*;
public class Main {
    private static int N, T;
    private static int[] top, bottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        top = new int[N];
        bottom = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bottom[i] = Integer.parseInt(st.nextToken());
        }

        int temp1 = 0, temp2 = 0;
        for(int i=0; i<T; i++) {
            temp1 = top[N-1];
            temp2 = bottom[N-1];
            for(int j=N-1; j>0; j--) {
                top[j] = top[j-1];
                bottom[j] = bottom[j-1];
            }
            top[0] = temp2;
            bottom[0] = temp1;
        }

        for(int i=0; i<N; i++) 
            System.out.printf("%d ", top[i]);
        System.out.println();
        for(int i=0; i<N; i++) 
            System.out.printf("%d ", bottom[i]);

    }
}