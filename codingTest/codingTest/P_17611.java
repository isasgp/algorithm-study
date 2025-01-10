package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_17611 {
	private static BufferedReader br;
	private static int n;
	private static int[] xInput, yInput;

	private static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        xInput = new int[n];
        yInput = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xInput[i] = Integer.parseInt(st.nextToken());
            yInput[i] = Integer.parseInt(st.nextToken());
        }
		br.close();
	}
	
	private static int max(int[] param) {
		int result = Integer.MIN_VALUE;
		for(int num: param) {
			if(num > result)
				result = num;
		}
		return result;
	}
	
	private static int min(int[] param) {
		int result = Integer.MAX_VALUE;
		for(int num: param) {
			if(num < result)
				result = num;
		}
		return result;
	}
	
	private static int solution(int[] param, int size) {
		int offset = min(param);
		for(int i=0; i<size; i++) {
			param[i] -= offset;
		}
		
		int[] imosArray = new int[max(param)+1];
		for(int i=0; i<size-1; i++) {
			imosArray[Math.min(param[i], param[i+1])]++;
			imosArray[Math.max(param[i], param[i+1])]--;
		}
		imosArray[Math.min(param[0], param[size-1])]++;
		imosArray[Math.max(param[0], param[size-1])]--;
		
		for(int i=1; i<imosArray.length; i++) {
			imosArray[i] += imosArray[i-1];
		}
		
		return max(imosArray);
	}

	public static void main(String[] args) throws IOException {
		input();

        int xResult = solution(xInput, n);
        int yResult = solution(yInput, n);

        System.out.println(Math.max(xResult, yResult));
	}
}
