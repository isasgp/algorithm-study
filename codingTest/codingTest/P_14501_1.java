package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백트래킹
public class P_14501_1 {
	private static BufferedReader br;
	private static int N, result;
	private static int[] T, P;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	private static void solution(int index, int p) {
		if(index == N) {
			result = Math.max(result, p);
			return;
		} else if(index > N) {
			return;
		}
		
		// 사용하는 케이스
		solution(index+T[index], p+P[index]);
		// 사용하지 않는 케이스
		solution(index+1, p);
		
	}

	public static void main(String[] args) throws IOException {
		input();
		
		result = Integer.MIN_VALUE;
		
		solution(0, 0);
		
		System.out.println(result);
		

	}

}
