package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1912 {
	private static BufferedReader br;
	private static int N;
	private static int[] prefixSum;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		prefixSum = new int[N];

		st = new StringTokenizer(br.readLine());
		prefixSum[0] = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			prefixSum[i] = Math.max(prefixSum[i-1] + temp, temp);
		}
		br.close();
	}
	public static void main(String[] args) throws IOException {
		input();
		
		Arrays.sort(prefixSum);

		System.out.println(prefixSum[prefixSum.length - 1]);
	}
}
