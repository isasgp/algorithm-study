package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1090 {
	private static BufferedReader br;
	private static int N;
	private static int[] Xarray;
	private static int[] Yarray;
	private static int Xmin, Xmax, Ymin, Ymax;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Xarray = new int[N];
		Yarray = new int[N];
		
		Xmin = Integer.MAX_VALUE;
		Xmax = Integer.MIN_VALUE;
		Ymin = Integer.MAX_VALUE;
		Ymax = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			Xarray[i] = Integer.parseInt(st.nextToken());
			Yarray[i] = Integer.parseInt(st.nextToken());
			
			if(Xmin > Xarray[i]) {Xmin = Xarray[i];}
			if(Xmax < Xarray[i]) {Xmax = Xarray[i];}
			if(Ymin > Yarray[i]) {Ymin = Yarray[i];}
			if(Ymax < Yarray[i]) {Ymax = Yarray[i];}
			
		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		
		long[] resultArray = new long[N];
		Arrays.fill(resultArray, Long.MAX_VALUE);
		
		for(int x : Xarray) {
			for(int y: Yarray) {
				long[] distArray = new long[N];
				
				for (int i=0; i<N; i++) {
					distArray[i] = Math.abs(x - Xarray[i]) + Math.abs(y - Yarray[i]);
				}
				
				Arrays.sort(distArray);
				
				long sum = 0;
				
				for(int i=0; i<N; i++) {
					sum += distArray[i];
					resultArray[i] = Math.min(sum, resultArray[i]);
				}
				
			}
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(resultArray[i] + (i==N ? "": " "));
		}
		
	}

}

//private static int calculateDistance(int point, int param) {
//int result = 0;
//
//result = point > param ? (point - param) : (param - point);
//
//return result;
//}

//{
//	input();
//	
//	for(int i=0; i<N; i++) {
//		long Xresult = Long.MAX_VALUE;
//		long Yresult = Long.MAX_VALUE;
//		for (int j = 0; j < N; j++) {
//			long temp = 0;
//		    for (int k = 0; k < i + 1; k++) {
//		        temp += calculateDistance(Xarray[j], Xarray[k]);
//		    }
//		    if (Xresult > temp) {Xresult = temp;}
//		}
//		
//		for (int j = 0; j < N; j++) {
//			long temp = 0;
//		    for (int k = 0; k < i + 1; k++) {
//		    	temp += calculateDistance(Yarray[j], Yarray[k]);
//		    }
//		    if (Yresult > temp) {Yresult = temp;}
//		}
//		if(i == N-1) {System.out.print((Xresult+Yresult));}
//		else {System.out.print((Xresult+Yresult) + " ");}
//		
//	}
//		
//		
//}

