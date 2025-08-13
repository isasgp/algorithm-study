import java.util.Scanner;

public class Main {
    public static int pow(int a, int b) {
        int result = 1;
        for(int i=0; i<b; i++) {
            result *= a;
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(pow(a, b));
    }
}