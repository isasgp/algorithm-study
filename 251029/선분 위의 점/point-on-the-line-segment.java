import java.util.Scanner;

public class Main {
    private static final int MAX_NUM = 100_000;
    private static int[] arr = new int[MAX_NUM + 1];

    private static int solution(int l, int r, int target) {

        if(l <= target && r >= target)
            return 1;
        
        return 0;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }

        for(int i=0; i<=MAX_NUM; i++) {
            arr[i] = i;
        }

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            int cnt = 0;
            for(int point: points) {
                cnt += solution(a, b, point);
            }

            System.out.println(cnt);
        }
        
        // Please write your code here.
    }
}