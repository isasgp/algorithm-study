package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_19532 {
	private static BufferedReader br;
	private static int a, b, c, d, e, f;
	
	private static void input() throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		f = Integer.parseInt(st.nextToken());
		
		br.close();
	}
	
	public static void main(String[] args) throws IOException {
		input();
		for(int i=-999; i<1000;i++) {
			for(int j=-999; j<1000;j++) {
				if((a*i+b*j == c) && (d*i+e*j == f)) {
					System.out.println(i+" "+j);
				}
			}
		}
	}
}
