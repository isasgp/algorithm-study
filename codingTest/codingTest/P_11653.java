package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11653 {
	private static BufferedReader br;
	private static int N;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		br.close();
	}
	
	private static StringBuilder calculate(int param) {
		StringBuilder sb = new StringBuilder();
		int temp = param;
		for(int i=2; i<(int)Math.sqrt(param)+1; i++) {
			while(temp % i == 0) {
				temp /= i;
				sb.append(i + "\n");
			}
		}
		if(temp != 1) {
			sb.append(temp);
		}
		return sb;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(calculate(N));

	}

}
