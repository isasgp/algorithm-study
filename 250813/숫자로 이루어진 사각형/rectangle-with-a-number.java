import java.util.Scanner;
public class Main {
    public static void printNum(int n) {
        int num = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print((num++)%9+1 + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printNum(n);
    }
}