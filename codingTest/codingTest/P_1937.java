package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1937 {
	private static BufferedReader br;
	private static int N;
	private static int[][] graph, dp;
	private static int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
			
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
	}
	
	private static int solution(int x, int y) {
		
		if(dp[x][y] != 0)
			return dp[x][y];
		
		for(int[] move: moves) {
			int nextX = x + move[0];
			int nextY = y + move[1];
			if(nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
				if(graph[x][y] < graph[nextX][nextY])
					dp[x][y] = Math.max(dp[x][y], solution(nextX, nextY) + 1);
			}
		}
		return dp[x][y];
	}

	public static void main(String[] args) throws IOException {
		input();
		dp = new int[N][N];
		
		int result = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result = Math.max(result, solution(i, j));
			}
		}
		// result 값은 이동한 횟수기 때문에 좌표의 수 출력을 위해 + 1
		System.out.println(++result);
	}

}
