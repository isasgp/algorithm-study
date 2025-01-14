package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_11660 {
	private static BufferedReader br;
	private static int N;
	private static int M;
	private static int[][] matrix;
	private static int[][] point1;
	private static int[][] point2;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N+1][N+1];
		point1 = new int[M][2];
		point2 = new int[M][2];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				matrix[i][j] = matrix[i][j-1] + matrix[i-1][j] - matrix[i-1][j-1] + Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			point1[i][0] = Integer.parseInt(st.nextToken());
			point1[i][1] = Integer.parseInt(st.nextToken());
			point2[i][0] = Integer.parseInt(st.nextToken());
			point2[i][1] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	private static int calculate(int[] param1, int[] param2) {
		int x1 = param1[0];
		int y1 = param1[1];
		int x2 = param2[0];
		int y2 = param2[1];
		
		return matrix[x2][y2] - matrix[x1-1][y2] - matrix[x2][y1-1] + matrix[x1-1][y1-1];
		
	}
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i=0; i<M; i++) {
			System.out.println(calculate(point1[i], point2[i]));
		}

	}

}
