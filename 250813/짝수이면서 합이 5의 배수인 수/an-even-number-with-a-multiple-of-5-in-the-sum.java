import java.util.Scanner;
public class Main {

    public static boolean isFiveMultiple(int n) {
        if(n<10 || n>99) {return false;}
        return ((n/10)+(n%10)) % 5 == 0;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String answer = isFiveMultiple(n) ? "Yes" : "No";
        System.out.println(answer);
    }
}