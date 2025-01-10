package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long array[] = new long[N];
		boolean result;
		
		for(int i=0; i<N; i++) {
			array[i] = Long.parseLong(br.readLine());
			result = true;
			for(int j=2;j<=1_000_000;j++) {
				if(array[i]%j == 0) {
					result = false;
					System.out.println("NO");
					break;
					}
				}
			if(result) {System.out.println("YES");}
		}
		br.close();
	}
}
