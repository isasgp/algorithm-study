import java.util.Scanner;
public class Main {
    public static boolean condition(int num) {
        if(num%2 == 0 || num%5 == 0 || (num%3 == 0 && num%9 != 0))
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int cnt = 0;
        for(int i=A; i<=B; i++) {
            if(condition(i))
                cnt++;
        }

        System.out.println(cnt);
    }
}