import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++) {
            dp1[i] = 1;
            dp2[i] = 1;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j])
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
            }
        }

        for(int i=n-1; i>=0; i--) {
            for(int j=n-1; j>i; j--) {
                if(arr[i] > arr[j])
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) {
            result = Math.max(result, dp1[i] + dp2[i] - 1);
        }

        System.out.println(result);
    }
}