import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        
        int temp1 = 0, temp2 = 0, temp3 = 0;

        for(int i=0; i<t; i++) {
            temp1 = l[n-1];
            temp2 = r[n-1];
            temp3 = d[n-1];
            for(int j=n-1; j>0; j--) {
                l[j] = l[j-1];
                r[j] = r[j-1];
                d[j] = d[j-1];
            }
            l[0] = temp3;
            r[0] = temp1;
            d[0] = temp2;
        }

        for(int i=0; i<n; i++) {
            System.out.print(l[i]+" ");
        }
        System.out.println();

        for(int i=0; i<n; i++) {
            System.out.print(r[i]+" ");
        }
        System.out.println();

        for(int i=0; i<n; i++) {
            System.out.print(d[i]+" ");
        }

    }
}