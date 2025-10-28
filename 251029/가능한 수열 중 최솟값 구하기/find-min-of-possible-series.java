import java.util.*;

public class Main {
    private static int n;
    private static int[] nums;

    private static String intArrToString(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int num: nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static boolean isBadSequence(int currIdx) {

        for(int L = 1; L <= (currIdx+1)/2; L++) {
            boolean isBad = true;
            for(int i=0; i<L; i++) {
                int index1 = currIdx - i;
                int index2 = currIdx - L - i;
                if(nums[index1] != nums[index2]) {
                    isBad = false;
                    break;
                }
            }
            if(isBad)
                return true;
        }

        return false;
    }

    public static boolean solution(int cnt) {
        if(cnt == n) {
            String result = intArrToString(nums);
            System.out.println(result);
            return true;
        }
        for(int num = 4; num <= 6; num++) {
            nums[cnt] = num;

            if(isBadSequence(cnt))
                continue;
            
            if(solution(cnt + 1))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];

        solution(0);
    }
}