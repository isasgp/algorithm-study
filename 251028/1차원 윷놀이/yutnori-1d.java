import java.util.*;
public class Main {
    private static int n, m, k;
    private static ArrayList<Integer> arr;
    private static int[] nums, horse;

    private static int result = 0;

    private static int calculate() {
        int score = 0;
        for(int i=0; i<k; i++)
            if(horse[i] >= m)
                score++;

        return score;
    }

    private static void solution(int cnt) {
        result = Math.max(result, calculate());

        if(cnt == n) {
            return;
        }

        for(int i=0; i<k; i++) {
            // if(horse[i] >= m)
            horse[i] += nums[i];
            solution(cnt + 1);
            horse[i] -= nums[i];
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        arr = new ArrayList<>();
        nums = new int[n];
        horse = new int[k];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        solution(0);

        System.out.println(result);
    }
}