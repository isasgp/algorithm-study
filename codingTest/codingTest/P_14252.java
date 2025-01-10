package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_14252 {
	private static BufferedReader br;
	private static int N;
	private static int[] Narray;
	
	private static void input() throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		Narray = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i< N; i++) {
			Narray[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	private static int calculateGCD(int param1, int param2) {
		// param1 >= param2 이도록 가정
		int temp = 0;
		while(param1%param2 != 0) {
			temp = param1%param2;
			param1 = param2;
			param2 = temp;
		}
		return param2;
	}
	
	public static void main(String[] args) throws IOException {
		input();
		
		Arrays.sort(Narray);
		int count = 0;
		
		for(int i=0; i<N-1; i++) {

			if(calculateGCD(Narray[i+1], Narray[i]) == 1) {continue;}
			
			for(int j=Narray[i]+1; j<Narray[i+1]; j++) {
				if(calculateGCD(j, Narray[i]) == 1 && calculateGCD(Narray[i+1], j) == 1) {
					count++;
					break;
				}
				if(Narray[i+1]-1 == j) {count += 2;}
			}
		}
		System.out.print(count);	
	}
}
