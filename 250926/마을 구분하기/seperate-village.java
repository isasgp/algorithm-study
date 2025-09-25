import java.util.*;

public class Main {
    private static final int MAX_NUM = 25;

    private static int n;
    private static int[][] grid;
    private static int[][] visited = new int[MAX_NUM+1][MAX_NUM+1];

    private static ArrayList<Integer> result = new ArrayList<>();

    private static int count = 0;

    private static boolean canGo(int x, int y) {
        if(x<0 || x>n-1 || y<0 || y>n-1)
            return false;

        if(visited[x][y] == 1)
            return false;

        if(grid[x][y] == 0)
            return false;

        return true;
    }
    private static int solution(int x, int y) {
        int size = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i=0; i<4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if(canGo(newX, newY)) {
                count++;
                visited[newX][newY] = 1;
                size += solution(newX, newY);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
                
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j] == 1 || grid[i][j] == 0)
                    continue;

                visited[i][j] = 1;
                result.add(solution(i, j));
            }
        }
        Collections.sort(result);

        System.out.println(result.size());
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}