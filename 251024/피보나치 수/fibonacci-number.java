import java.util.Scanner;
public class Main {
    private static final int MAX_NUM = 45;
    private static int solution(int n) {
        int[] num = new int[MAX_NUM+1];

        num[1] = 1;
        num[2] = 1;

        for(int i=3; i<=n; i++) {
            num[i] = num[i-1] + num[i-2];
        }
        

        return num[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = solution(n);

        System.out.println(result);
    }
}