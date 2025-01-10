package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_14568 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int candy = Integer.parseInt(br.readLine());
		long result = 0;
		
		for (int i=1; i<candy; i++) {
			for(int j=1;j<candy; j++) {
				for(int k=1; k<candy; k++) {
					if(i+j+k != candy) {continue;}
					if(j-i<2) {continue;}
					if(k%2 != 0) {continue;}
					result++;
				}
			}
		}
		System.out.println(result);
		
		br.close();
	}

}
