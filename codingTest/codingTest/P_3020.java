package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_3020 {
	private static BufferedReader br;
	private static int N, H;
	private static int[] top, bottom;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		top = new int[H];
		bottom = new int[H];
		
		// 이모스법
		// 왼쪽 -> 오른쪽 기준으로, 시작지점에는 1, 끝 지점+1 에는 -1
		// 짝수번째에는 -1 부분이 기준 바깥에 있으므로(H+1 지점) 굳이 설정하지 않음
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i%2 == 0) {
				bottom[0]++;
				if(num >= H) { continue;}
				bottom[num]--;
			} else {
				if(num > H) { continue;}
				top[H-num]++;
			}
		}
		br.close();
	}

	public static void main(String[] args) throws IOException {
		input();
		
		int[] result = new int[H];
		
		result[0] = top[0] + bottom[0];
		
		
		for(int i=1; i<H; i++) {
			bottom[i] += bottom[i-1];
			top[i] += top[i-1];
			result[i] = top[i] + bottom[i];
		}
		
		int min = Integer.MAX_VALUE;
		int count = 0;
		for(int i=0; i<H; i++) {
			if(result[i] < min) {
				count = 1;
				min = result[i];
			} else if(result[i] == min) {count++;}
		}
		System.out.printf("%d %d\n", min, count);
	}
}
