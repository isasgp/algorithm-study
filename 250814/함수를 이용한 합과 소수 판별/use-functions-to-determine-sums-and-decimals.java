import java.util.Scanner;
public class Main {
    public static boolean isPrimeNum(int num) {
        int sqrtNum = (int)Math.sqrt(num);

        for(int i=2;i<=sqrtNum;i++) {
            if(num%i == 0)
                return false;
        }
        return true;
    }

    public static boolean condition(int num) {
        if(!isPrimeNum(num))
            return false;

        if(num >= 100)
            return (num/100 + num/10%10 + num%10)%2 == 0;
        if(num >= 10)
            return (num/10 + num%10)%2 == 0;
        return num%2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0;

        for(int i=a; i<=b; i++) {
            if(condition(i))
                cnt++;
        }

        System.out.println(cnt);
    }
}