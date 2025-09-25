import java.util.*;
import java.io.*;

public class Main {
    private static final int MAX_NUM = 1_000;

    private static int n, m;
    private static ArrayList<Integer>[] graph = new ArrayList[MAX_NUM+1];
    private static boolean[] visited = new boolean[MAX_NUM+1];
    private static int result = 0;

    private static void DFS(int vertex) {
        for(int i=0; i<graph[vertex].size(); i++) {
            int curV = graph[vertex].get(i);
            if(!visited[curV]) {
                visited[curV] = true;
                result++;
                DFS(curV);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        visited[1] = true;
        DFS(1);

        System.out.println(result);
    }
}