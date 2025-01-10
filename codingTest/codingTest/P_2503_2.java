package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 재귀 사용
public class P_2503_2 {
	private static BufferedReader br;
	private static int N;
	private static long[][] array;
	private static long result;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		array = new long[N][3];
		
		for(int i=0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			array[i][0] = Long.parseLong(st.nextToken());
			array[i][1] = Long.parseLong(st.nextToken());
			array[i][2] = Long.parseLong(st.nextToken());
		}
		br.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
