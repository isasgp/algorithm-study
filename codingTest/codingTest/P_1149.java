package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1149 {
	private static BufferedReader br;
	private static int N;
	private static int[][] house;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][3];
		
		// RGB == 0: RED
		// RGB == 1: BLUE
		// RGB == 2: GREEN
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		input();
		
		int[][] dp = new int[N][3];
		dp[0] = house[0];
		
		for(int index=1; index<N; index++) {
			dp[index][0] = Math.min(dp[index-1][1], dp[index-1][1]) + house[index][0];
			dp[index][1] = Math.min(dp[index-1][0], dp[index-1][2]) + house[index][1];
			dp[index][2] = Math.min(dp[index-1][0], dp[index-1][1]) + house[index][2];
		}
		
		System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));

	}

}
