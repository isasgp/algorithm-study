package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_11726 {
	private static int N;
    private static int[] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        
        br.close();
    }

    public static void main(String[] args) throws IOException {
        input();

        for (int idx = 0; idx < N; idx++) {
            if (idx < 3) {
                dp[idx] = idx + 1;
            } else {
                dp[idx] = (dp[idx-1] + dp[idx-2]) % 10007;
            }
        }

        System.out.println(dp[N-1]);
    }
}