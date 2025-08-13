import java.util.Scanner;
public class Main {
    public static boolean isLeapYear(int y) {
        if(y%4 == 0 && y%100 == 0 && y%400 == 0)
            return true;
        if(y%4 == 0 && y%100 == 0)
            return false;
        if(y%4 == 0)
            return true;
        return false;
    }

    public static String seanson(int y, int m, int d) {
        int[] date = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if(isLeapYear(y))
            date[2] = 29;

        if(date[m] < d)
            return "-1";
        
        if(m >= 3 && m <= 5)
            return "Spring";
        if(m >= 6 && m <= 8)
            return "Summer";
        if(m >= 9 && m <= 11)
            return "Fall";
        if(m == 12 || m == 1 || m == 2)
            return "Winter";
        return "-1";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(seanson(y, m, d));
    }
}