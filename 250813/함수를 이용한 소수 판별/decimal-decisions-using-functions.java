import java.util.Scanner;

public class Main {
    public static boolean isPrimeNum(int num) {
        int numSqrt = (int)Math.sqrt(num);
        for(int i=2; i<= numSqrt; i++) {
            if(num%i == 0)
                return false;
        }
        return true;
    }

    public static int sumPrimeNum(int a, int b) {
        int sum = 0;
        for(int i=a; i<=b; i++) {
            if(isPrimeNum(i))
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(sumPrimeNum(a, b));
    }
}