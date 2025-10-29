import java.util.Scanner;
public class Main {
    private static int n;
    private static int[] arr;

    private static int solution(int target) {
        int left = 0;
        int right = n - 1;
        int midIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(arr[mid] >= target) {
                midIdx = Math.min(midIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if(arr[midIdx] != target)
            return -1;

        return midIdx + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target = sc.nextInt();

            System.out.println(solution(target));
        }
    }
}