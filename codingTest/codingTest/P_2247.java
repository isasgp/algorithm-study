package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_2247 {
	private static BufferedReader br;
	private static long n;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Long.parseLong(br.readLine());
		
		br.close();
	}
	
	private static long calculate(long param) {
		long temp = (long)(param/2);
		long result = 0;
		for(int i=2; i<temp+1; i++) {
			result += i*((long)(param / i)-1);
		}
		return result % 1_000_000;
		
	}
	public static void main(String[] args) throws IOException {
		input();
		System.out.println(calculate(n));
		

	}

}
