package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_14719 {
	private static BufferedReader br;
	private static int H;
	private static int W;
	private static int[] array;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		array = new int[W];
		
		int temp = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++) {
			temp = Integer.parseInt(st.nextToken());
			if(H < temp) {temp = H;}
			array[i] = temp;
		}
		
		br.close();
	}
	
	private static int arrayMax(int[] param) {
		int result = Integer.MIN_VALUE;
		
		for(int temp: param) {
			if(result < temp) {result = temp;}
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		
		int result = 0;
		
		for(int i=1; i<W-1; i++) {
			int leftMax = arrayMax(Arrays.copyOfRange(array, 0, i));
			int rightMax = arrayMax(Arrays.copyOfRange(array, i+1, array.length));
			
			int compare = Math.min(leftMax, rightMax);
			
			if(array[i] < compare) {
				result += compare - array[i];
			}
		}
		System.out.println(result);
	}
}
