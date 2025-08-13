import java.util.Scanner;
public class Main {
    public static boolean isRight(int[] arrA, int[] arrB) {
        for(int idx=0; idx<=arrA.length-arrB.length; idx++) {
            int cnt = 0;
            if(arrA[idx] == arrB[0]) {
                for(int i=0; i<arrB.length; i++) {
                    if(arrA[idx+i] == arrB[i])
                        cnt++;
                }
            }
            if (cnt == arrB.length) return true;
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();

        if(isRight(a, b))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}