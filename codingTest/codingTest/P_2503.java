package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 브루트포스 사용
public class P_2503 {
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
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				for(int k=1; k<10; k++) {
					if(i==j || j==k || i==k) {continue;}
					boolean isAnswer = true;
					for(int a=0; a<N;a++) {
						int strike_cnt = 0;
						int ball_cnt = 0;
						if(array[a][0]/100 == i)
							strike_cnt++;
						if(array[a][0]%100/10 == j)
							strike_cnt++;
						if(array[a][0]%10 == k)
							strike_cnt++;
						if(array[a][0]/100 == j || array[a][0]/100 == k)
							ball_cnt++;
						if(array[a][0]%100/10 == i || array[a][0]%100/10 == k)
							ball_cnt++;
						if(array[a][0]%10 == j || array[a][0]%10 == i)
							ball_cnt++;
						
						if(array[a][1] != strike_cnt || array[a][2] != ball_cnt) {isAnswer=false;break;}
					}
					if(isAnswer) {result++;}
				}
			}
		}
		System.out.println(result);
	}

}
