package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_19942 {
	private static BufferedReader br;
	private static int N, mp, mf, ms, mv;
	private static int[] p, f, s, v, c;
	private static long result;
	private static StringBuilder resultList;
	
	private static void input() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		p = new int[N];
		f = new int[N];
		s = new int[N];
		v = new int[N];
		c = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			f[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void solution(int index, long P, long F, int S, int V, int C, StringBuilder useList) {
		if (index == N) {
			if (C == 0 || P < mp || F < mf || S < ms || V < mv)
				return;
			
			if(result > C) {
				result = C;
				resultList = new StringBuilder(useList);
			} else if (result == C) {
				if(useList.toString().compareTo(resultList.toString()) < 0)
					resultList = new StringBuilder(useList);
			}
				
			return;
		}
		// 재료를 선택한 케이스
		StringBuilder selectedList = new StringBuilder(useList).append(index + 1).append(" ");
		solution(index+1, P + p[index], F + f[index], S + s[index], V + v[index], C + c[index], selectedList);
		// 재료를 선택하지 않은 케이스
		solution(index+1, P, F, S, V, C, useList);
		
	}

	public static void main(String[] args) throws IOException {
		input();
		
		result = Long.MAX_VALUE;
		resultList = new StringBuilder();
		
		StringBuilder temp = new StringBuilder();
		
		solution(0, 0, 0, 0, 0, 0, temp);
		
		if(result == Long.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
			System.out.println(resultList.toString().trim());
		}
	}

}
