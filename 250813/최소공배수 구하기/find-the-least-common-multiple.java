import java.util.Scanner;

public class Main {

    public static int gcd(int n, int m) {
        if(n > m) {
            int temp = m;
            m = n;
            n = temp;
        }
        int r = 0;
        while(true) {
            r = m % n;
            if (r == 0) {return n;}
            m = n;
            n = r;
        }
    }

    public static int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(lcm(n, m));
    }
}