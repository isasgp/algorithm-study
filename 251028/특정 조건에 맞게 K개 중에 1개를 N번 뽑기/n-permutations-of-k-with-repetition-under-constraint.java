import java.util.*;
import java.io.*;

public class Main {
    private static int k, n;
    private static ArrayList<Integer> arr;

    private static void solution(int cnt) {
        if(cnt == n) {
            int firstNum = arr.get(0);
            if(n > 1) {
                boolean isSame = true;
                for(int i=1; i<arr.size(); i++) {
                    if(firstNum != arr.get(i)) {
                        isSame = false;
                        break;
                    }
                }
                if(isSame)
                    return;
            }
            

            for(int i=0; i<arr.size(); i++)
                System.out.print(arr.get(i)+" ");
            System.out.println();
            return;
        }

        for(int i=1; i<=k; i++) {
            arr.add(i);
            solution(cnt + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();

        solution(0);
    }
}