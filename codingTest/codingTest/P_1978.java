package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1978 {
	private static BufferedReader br;
	private static int N;
	private static int[] Narray;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Narray = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Narray[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	private static int calculate(int param) {
		int count = 0;
		for(int i=1; i<(int)Math.sqrt(param)+1; i++) {
			if(param % i == 0) {
				if(i == (param/i)) {
					count++;
					continue;
				}
				count += 2;
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		input();
		int count = 0;
		for(int num : Narray) {
			if(calculate(num) == 2) {count++;}
		}
		System.out.println(count);
	}

}
