import java.util.Scanner;
public class Main {

    public static boolean condition(int num) {
        while(num > 0) {
            if(num%3 == 0)
                return true;
            if(num%10 == 3 || num%10 == 6 || num%10 == 9)
                return true;
            
            num /= 10;
        }
        return false;
    }

    public static int countAnswer(int a, int b) {
        if (a > b) { int t = a; a = b; b = t; }

        int count = 0;

        for(int i=a; i<=b; i++) {
            if(condition(i))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(countAnswer(A, B));
    }
}