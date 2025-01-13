package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다이나믹 프로그래밍 바텀업
public class P_14501_3 {
	private static BufferedReader br;
	private static int N;
	private static int[] T, P;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	

	public static void main(String[] args) throws IOException {
		input();
		
		int[] dp = new int[N+1];
		
		for(int i=N-1; i>=0; i--) {
			if(i+T[i] > N) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i+T[i]] + P[i], dp[i+1]);
			}
		}
		
		System.out.println(dp[0]);
		
		
	}

}