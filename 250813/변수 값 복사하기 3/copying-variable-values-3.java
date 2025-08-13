public class Main {
    public static void main(String[] args) {
        int a = 1;
        int b = 5;
        int c = 3;
        a = c;
        a += c;
        b -= c;
        System.out.printf("%d\n%d\n%d", a, b, c);
    }
}