import java.util.*;

public class Main {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int MAX_NUM = 1_000_000;
    private static final int TARGET_NUM = 1;

    private static int n;
    private static Queue<Integer> q;
    private static int[] dist;
    private static boolean[] visited;

    private static int calculateValue(int method, int val) {
        if(method == 1) {
            return val - 1;

        } else if(method == 2) {
            return val + 1;

        } else if(method == 3) {
            if(val % 2 == 0)
                return val / 2;

            return INT_MAX;

        } else if(method == 4) {
            if(val % 3 == 0)
                return val / 3;

            return INT_MAX;

        } else {

            return INT_MAX;
        }
    }

    private static boolean canGo(int n) {
        if(n < 1 || n > MAX_NUM)
            return false;

        if(visited[n])
            return false;

        if(n == INT_MAX)
            return false;

        return true;
    }

    private static int solution() {
        q.add(n);
        visited[n] = true;

        boolean isFind = false;

        while(!q.isEmpty()) {
            int currNum = q.poll();
            for(int method=1; method<=4; method++) {
                int newNum = calculateValue(method, currNum);

                if(canGo(newNum)) {
                    dist[newNum] = dist[currNum] + 1;
                    visited[newNum] = true;

                    if(newNum == TARGET_NUM) {
                        isFind = true;
                        break;
                    }
                    q.add(newNum);
                }
            }
            if(isFind)
                break;
        }
        return dist[1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = new LinkedList<>();

        dist = new int[MAX_NUM + 1];
        visited = new boolean[MAX_NUM + 1];
        int result = solution();
        System.out.println(result);
    }
}