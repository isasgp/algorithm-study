package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹
public class P_12865_1 {
	private static BufferedReader br;
	private static int N, K, result;
	private static int[] W, V;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		W = new int[N];
		V = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	private static void solution(int index, int w, int v) {
		if(index == N && K >= w) {
			result = Math.max(result, v);
			return;
		} else if(K < w) {
			return;
		}
		// 선택할 경우
		solution(index+1, w+W[index], v+V[index]);
		// 선택하지 않을 경우
		solution(index+1, w, v);
	}

	public static void main(String[] args) throws IOException {
		input();
		
		result = Integer.MIN_VALUE;
		
		solution(0, 0, 0);
		
		System.out.println(result);
	}

}
