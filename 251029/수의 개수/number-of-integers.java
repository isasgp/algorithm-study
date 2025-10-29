import java.util.Scanner;
public class Main {
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
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            
            int lower = lowerBound(x);
            int upper = upperBound(x);

            if(lower == upper) {
                System.out.println(0);
            } else {
                System.out.println(upper - lower);
            }
            
        }
    }
}