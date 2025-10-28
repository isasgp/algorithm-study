import java.util.Scanner;
public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static int n;
    private static int[] arr;
    private static int result = INT_MAX;

    private static void solution(int idx, int cnt) {
        if(idx >= n-1) {
            result = Math.min(result, cnt);
            return;
        }

        int jump = arr[idx];
        
        for(int i = 1; i <= jump; i++) {
            solution(idx + i, cnt + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        solution(0, 0);

        if(result == INT_MAX)
            result = -1;

        System.out.println(result);
        
    }
}