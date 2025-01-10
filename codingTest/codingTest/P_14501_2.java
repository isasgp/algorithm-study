package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_14501_2 {
	private static BufferedReader br;
	private static int N;
	private static int[] T, P, dp;
	
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
		
		dp = new int[N+1];
		
		Arrays.fill(dp, -1);
		
		br.close();
	}
	
	private static int solution(int index) {
		if(index == N) {
			return 0;
		} else if(index > N) {
			return Integer.MIN_VALUE;
		}
		
		if(dp[index] != -1) {
			return dp[index];
		}
		
		dp[index] = Math.max(solution(index+T[index]) + P[index], solution(index+1));
		
		return dp[index];
	}

	public static void main(String[] args) throws IOException {
		input();
		
		System.out.println(solution(0));
	}

}
