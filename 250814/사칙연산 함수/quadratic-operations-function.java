import java.util.Scanner;
public class Main {
    public static int add(int x, int y) {
        return x + y;
    }
    public static int subtract(int x, int y) {
        return x - y;
    }
    public static int multiple(int x, int y) {
        return x * y;
    }
    public static int divide(int x, int y) {
        return x / y;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();

        switch (o) {
            case '+':
                System.out.println(a+" "+o+" "+c+" = "+add(a, c));
                break;
            case '-':
                System.out.println(a+" "+o+" "+c+" = "+subtract(a, c));
                break;
            case '*':
                System.out.println(a+" "+o+" "+c+" = "+multiple(a, c));
                break;
            case '/':
                System.out.println(a+" "+o+" "+c+" = "+divide(a, c));
                break;
            default:
                System.out.println("False");
                break;
        }
    }
}