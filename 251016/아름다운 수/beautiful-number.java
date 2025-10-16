import java.util.*;

public class Main {
    private static final int LIMIT = 4;

    private static int n;
    private static ArrayList<Integer> arr;
    private static int result;

    private static boolean isBeautifulNum() {
        int currNum = 0;

        for(int i=0; i<arr.size(); i++) {
            currNum = arr.get(i);
            int cnt = 0;
            for(int j=1; j<currNum; j++) {
                if(i+j >= arr.size())
                    return false;
                if(currNum != arr.get(i+j))
                    return false;
                cnt++;
            }
            i += cnt;
        }

        return true;
    }

    private static void solution(int currNum) {
        if(currNum == n) {
            if(isBeautifulNum()) {
                result++;
            }
            return;
        }

        for(int select=1; select<=LIMIT; select++) {
            arr.add(select);
            solution(currNum + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new ArrayList<>();

        solution(0);

        System.out.println(result);
    }
}