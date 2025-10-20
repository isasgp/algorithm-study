import java.util.*;

public class Main {
    private static int n;

    private static ArrayList<Line> arr;
    private static int result = 0;

    private static class Line {
        int l;
        int r;
        public Line(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    private static void solution(int index, int count, int lastR) {
        if(index == n) {
            result = Math.max(result, count);
            return;
        }

        Line thisLine = arr.get(index);

        if(lastR < thisLine.r) {
            solution(index + 1, count + 1, thisLine.r);
        } else {
            solution(index + 1, count, lastR);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            arr.add(new Line(l, r));
        }

        arr.sort((o1, o2) -> o1.l - o2.l);

        solution(0, 0, -1);

        System.out.println(result);
    }
}