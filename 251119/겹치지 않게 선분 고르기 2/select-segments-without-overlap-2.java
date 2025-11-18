import java.util.*;

public class Main {
    private static class Line {
        int start;
        int end;
        private Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Line> segments = new ArrayList<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            segments.add(new Line(start, end));
        }

        segments.sort((o1, o2) -> {
            if(o1.start == o2.start)
                return Integer.compare(o1.end, o2.end);
            return Integer.compare(o1.start, o2.start);
        });

        for(int i=1; i<n; i++) {
            Line currLine = segments.get(i);
            for(int j=0; j<i; j++) {
                Line pastLine = segments.get(j);
                if(pastLine.start > currLine.end ||
                pastLine.end < currLine.start)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int result = 0;
        for(int i=0; i<n; i++) 
            result = Math.max(result, dp[i]);
        
        System.out.println(++result);
    }
}