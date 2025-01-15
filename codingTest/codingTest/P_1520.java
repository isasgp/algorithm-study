package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1520 {
	private static BufferedReader br;
	private static int M, N;
	private static int[][] graph, dp;
	private static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		graph = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
	
	private static int solution(int x, int y) {
		
		if(x == M-1 && y == N-1)
			return 1;
		
		if(dp[x][y] != -1)
			return dp[x][y];
		
		int count = 0;
		
		for(int[] move: moves) {
			int nextX = x + move[0];
			int nextY = y + move[1];
			if(nextX >= 0 && nextY >= 0 && nextX < M && nextY < N) {
				if(graph[x][y] > graph[nextX][nextY])
					count += solution(nextX, nextY);
			}
		}
		dp[x][y] = count;
		
		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		input();
		
		dp = new int[M][N];
		
		for(int i=0; i<M; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(solution(0, 0));
	}

}
