import java.util.Scanner;
public class Main {
    private static int n;
    private static int[][] num, moveDir;
    private static int result = 0;

    private static boolean inRange(int x, int y) {
        return !(x < 0 || x >= n || y < 0 || y >= n);
    }

    private static void solution(int r, int c, int cnt) {
        // System.out.println("x: "+r+" y: "+c+" cnt: "+cnt);
        result = Math.max(result, cnt);
        int currX = r;
        int currY = c;
        int currVal = num[currX][currY];
        int currDir = moveDir[currX][currY];

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int newX = currX + dx[currDir];
        int newY = currY + dy[currDir];

        while(inRange(newX, newY)) {
            if(num[newX][newY] > num[r][c]) {
                solution(newX, newY, cnt + 1);
            }
            currX = newX;
            currY = newY;

            newX = currX + dx[currDir];
            newY = currY + dy[currDir];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        num = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = sc.nextInt();
            }
        }
        
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt() - 1;
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        
        solution(r, c, 0);

        System.out.println(result);
    }
}