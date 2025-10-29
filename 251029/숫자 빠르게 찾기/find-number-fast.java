import java.util.Scanner;
public class Main {
    private static int n;
    private static int[] arr;

    private static int solution(int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid + 1;
            } else if(arr[mid] > target) {
                right = mid - 1;
            } else if(arr[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(solution(x));
        }
    }
}