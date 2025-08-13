import java.util.Scanner;
public class Main {
    public static boolean isValidate(int m, int d) {
        int[] daysInMonth = {
            0,
            31, // 1월
            28, // 2월
            31, // 3월
            30, // 4월
            31, // 5월
            30, // 6월
            31, // 7월
            31, // 8월
            30, // 9월
            31, // 10월
            30, // 11월
            31  // 12월
        };

        // 유효한 월 범위인지 확인
        if (m < 1 || m > 12) return false;

        // 유효한 일 범위인지 확인
        return d >= 1 && d <= daysInMonth[m];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        System.out.println(isValidate(m, d) ? "Yes": "No");
    }
}