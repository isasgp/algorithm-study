package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2559 {
	private static BufferedReader br;
	private static int N;
	private static int K;
	private static int[] prefixSum;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		prefixSum = new int[N+1];

		st = new StringTokenizer(br.readLine());
		prefixSum[0] = 0;
		
		for(int i=1; i<N+1; i++) {
			prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		
		int result = Integer.MIN_VALUE;
		
		for(int i=K; i<N+1; i++) {
			result = Math.max(result, prefixSum[i] - prefixSum[i-K]);
		}
		System.out.println(result);
	}
}
