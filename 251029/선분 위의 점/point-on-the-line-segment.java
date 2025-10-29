import java.util.*;

public class Main {
    private static final int MAX_NUM = 100_000;
    private static int n;
    private static int[] arr;

    private static int lowerBound(int target) {
        int left = 0;
        int right = n - 1;

        int minIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] >= target) {
                minIdx = Math.min(minIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return minIdx;
    }

    private static int upperBound(int target) {
        int left = 0;
        int right = n - 1;

        int minIdx = n;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] > target) {
                minIdx = Math.min(minIdx, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return minIdx;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(upperBound(b) - lowerBound(a));
        }
        
        // Please write your code here.
    }
}