package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//다이나믹 프로그래밍 바텀업
public class P_12865_3 {
	private static BufferedReader br;
	private static int N, K;
	private static int[] W, V;
	
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

		br.close();
	}
	

	public static void main(String[] args) throws IOException {
		input();
		
		int[][] dp = new int[N+1][K+1];
		
		for(int index=1; index<N+1; index++) {
			for(int weight=1; weight<K+1; weight++) {
				if(weight < W[index-1]) {
					dp[index][weight] = dp[index-1][weight];
				} else {
					dp[index][weight] = Math.max(dp[index-1][weight-W[index-1]] + V[index-1], dp[index-1][weight]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
	
}