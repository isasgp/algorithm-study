import java.util.*;

public class Main {
    private static int n, m;
    private static ArrayList<Horizon> arr;
    private static ArrayList<Horizon> selectedLines;
    private static int[] finalPosition;
    private static int result = 1_000_000;

    private static class Horizon {
        int base;
        int order;

        public Horizon(int base, int order) {
            this.base = base;
            this.order = order;
        }
    }

    private static void calculateFinal() {
        for(int num=0; num<n; num++) {
            int thisNum = num;
            for(int i=0; i<arr.size(); i++) {
                int thisBase = arr.get(i).base;

                if(thisNum == thisBase) {
                    thisNum = move(thisNum, 1);
                } else if(thisNum - 1 == thisBase) {
                    thisNum = move(thisNum, -1);
                }
            }
            finalPosition[num] = thisNum;
        }
    }

    private static int move(int curr, int dir) {
        if(dir == -1) {
            return curr - 1;
        } else if(dir == 1) {
            return curr + 1;
        } else {
            return 0;
        }
    }

    private static boolean compareToFinal() {
        for(int num=0; num<n; num++) {
            int thisNum = num;
            for(int i=0; i<selectedLines.size(); i++) {
                int thisBase = selectedLines.get(i).base;

                if(thisNum == thisBase) {
                    thisNum = move(thisNum, 1);
                } else if(thisNum - 1 == thisBase) {
                    thisNum = move(thisNum, -1);
                }
            }
            if(thisNum != finalPosition[num])
                return false;
        }
        return true;
    }

    private static void solution(int cnt) {
        if (selectedLines.size() >= result) {
            return;
        }

        if(cnt == m) {
            if (compareToFinal()) { 
                result = Math.min(result, selectedLines.size());
            }
            return;
        }
        if(compareToFinal()) {
            result = Math.min(result, selectedLines.size());
        }

        // 선택 하는 경우
        for(int base = 0; base<n; base++) {
            selectedLines.add(new Horizon(base, cnt));
            solution(cnt + 1);
            selectedLines.remove(selectedLines.size() - 1); // 백트래킹
        }

        // 선택 안하는 경우
        solution(cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        finalPosition = new int[n];
        arr = new ArrayList<>();
        selectedLines = new ArrayList<>();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt();
            arr.add(new Horizon(a, b));
        }
        arr.sort((o1, o2) -> o1.order - o2.order);

        calculateFinal();

        solution(0);

        System.out.println(result);
    }
}