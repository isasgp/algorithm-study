package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2961 {
	private static BufferedReader br;
	private static int N;
	private static long[] S, B;
	private static long result;
	
	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		S = new long[N];
		B = new long[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Long.parseLong(st.nextToken());
			B[i] = Long.parseLong(st.nextToken());
		}
		br.close();
	}
	
	private static void solution(int index, long sour, long bitter, int use) {
		
		if (index == N) {
			if (use == 0)
				return;
			
			result = Math.min(result, Math.abs(sour - bitter));
			return;
		}
		// 재료를 선택한 케이스
		solution(index+1, sour * S[index], bitter + B[index], use + 1);
		// 재료를 선택하지 않은 케이스
		solution(index+1, sour, bitter, use);
		
	}

	public static void main(String[] args) throws IOException {
		input();
		
		result = Long.MAX_VALUE;
		
		solution(0, 1, 0, 0);
		
		System.out.println(result);
	}

}
