package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2304 {
	private static BufferedReader br;
	private static int N;
	private static int[][] point;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
				
		point = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			point[i][0] = Integer.parseInt(st.nextToken());
			point[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		
		int maxIndex = Integer.MIN_VALUE;
		int maxH = Integer.MIN_VALUE;
		
		Arrays.sort(point, (x1, x2) -> Integer.compare(x1[0], x2[0]));		
		
		for(int i=0; i<N; i++) {
			if(point[i][1] > maxH) {
				maxIndex = i;
				maxH = point[i][1];
			}
			
		}
		
		int result = 0;

		int currentMaxH = Integer.MIN_VALUE;
		
		for(int i=0; i<maxIndex; i++) {
			while(point[i+1][0] != point[i][0]++) {
				if(point[i][1] > currentMaxH) {currentMaxH = point[i][1];}
				result += currentMaxH;
			}
		}
		
		currentMaxH = Integer.MIN_VALUE;
		
		for(int i=N-1; i>maxIndex; i--) {
			while(point[i-1][0] != point[i][0]--) {
				if(point[i][1] > currentMaxH) {currentMaxH = point[i][1];}
				result += currentMaxH;
			}
		}
	
		result += maxH;
		
		System.out.println(result);
	}
}
