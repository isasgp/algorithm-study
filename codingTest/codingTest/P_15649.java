package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_15649 {
	private static BufferedReader br;
	private static int N, M;
    private static boolean[] visited;
    private static int[] result;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		result = new int[M];
		
		br.close();
	}
	
	private static void solution(int depth) {
		if(depth == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(result[i]).append(" ");
			}
			System.out.println(sb.toString().trim());
			return;
		}
		for(int i=1; i<N+1; i++) {
			if(visited[i]) {continue;}
			visited[i] = true;
			result[depth] = i;
			solution(depth+1);
			visited[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		input();
		
		ArrayList<Integer> list = new ArrayList<>();
		
		solution(0);
	}

}
