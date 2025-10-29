import java.util.Scanner;

public class Main {
    private static long solution(long l, long r, long target) {
        long left = l;
        long right = r;

        long cnt = 0;
        while(left <= right) {
            long mid = (left + right) / 2;
            // System.out.println(mid);
            cnt++;
            if(mid == target) {
                // System.out.println("cnt: "+cnt);
                return cnt;
            } else if(mid < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;
        
        for(long num = a; num <= b; num++) {
            long val = solution(1, m, num);
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
        }
        
        System.out.println(minVal+" "+maxVal);
    }
}