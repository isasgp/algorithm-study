package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_15736 {
	private static BufferedReader br;
	private static long N;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		br.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		System.out.println((long)Math.sqrt(N));

	}

}
