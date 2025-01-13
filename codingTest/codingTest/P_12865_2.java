package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//다이나믹 프로그래밍 탑다운
public class P_12865_2 {
	private static BufferedReader br;
	private static int N, K;
	private static int[] W, V;
	private static int[][] dp;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N];
		V = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][100_001];
		
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], -1);
		}

		
		br.close();
	}
	
	private static int solution(int index, int w) {
		if(w > K)
			return Integer.MIN_VALUE;
		
		if(index == N)
			return 0;
		
		if(dp[index][w] != -1)
			return dp[index][w];
		
		dp[index][w] = Math.max(solution(index-1, w+W[index]) + V[index], solution(index+1, w));
		
		return dp[index][w];

	}

	public static void main(String[] args) throws IOException {
		input();
		
		System.out.println(solution(0, 0));
	}
	
}
