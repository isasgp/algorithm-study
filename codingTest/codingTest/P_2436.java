package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2436 {
	private static BufferedReader br;
	private static long gcd, lcm;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		gcd = Long.parseLong(st.nextToken());
		lcm = Long.parseLong(st.nextToken());
		
		br.close();
	}
	
	private static long calculateGcd(long param1, long param2) {
		// param1 >= param2 라 가정
		long a = param1;
		long b = param2;
		
		long temp = 0;
		while (a%b != 0) {
			temp = a%b;
			a = b;
			b = temp;
		}
		return b;
	}
	
//	private static long calculateLcm(long param1, long param2) {
//		// param1 >= param2 라 가정
//		long a = param1;
//		long b = param2;
//		
//		return a * b / calculateGcd(a, b);
//	}

	public static void main(String[] args) throws IOException {
		input();

		long result1 = 0;
		long result2 = 0;
		
		long temp = Long.MAX_VALUE;
		long combine = gcd * lcm;
		
		for(long i=gcd; i*i<combine+1; i+=gcd) {
			if(combine % i != 0) {continue;}
			long j = combine/i;
			if(calculateGcd(j ,i) == gcd) {
				if(temp > i+j) {
					temp = i + j;
					result1 = i;
					result2 = j;
				}
			}
		}
		System.out.printf("%d %d\n", result1, result2);
	}

}
