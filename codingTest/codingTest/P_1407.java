package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1407 {
	private static BufferedReader br;
	private static long A, B;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		
		br.close();
	}
	
	private static long calculate(long param) {
		long temp = param;
		for(int i=1; i<100; i++) {
			temp += (long)(Math.pow(2, i)-Math.pow(2, i-1))*(long)(param / Math.pow(2, i));
		}
		return temp;
		
	}

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(calculate(B) - calculate(A-1));


	}

}
