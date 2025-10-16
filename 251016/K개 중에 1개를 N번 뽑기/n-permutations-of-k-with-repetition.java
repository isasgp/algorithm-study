import java.util.*;

public class Main {
    private static int n, k;
    private static ArrayList<Integer> arr;

    private static void printArr() {
        for(int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    private static void solution(int currNum) {
        if(currNum == n) {
            printArr();
            return;
        }
        for(int select = 1; select <= k; select++) {
            arr.add(select);
            solution(currNum + 1);
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        arr = new ArrayList<>();
        
        solution(0);
    }
}