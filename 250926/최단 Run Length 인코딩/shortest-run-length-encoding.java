import java.util.*;
import java.io.*;

public class Main {

    private static String rightShift(String str) {
        StringBuilder sb = new StringBuilder(str.substring(str.length()-1, str.length()));
        sb.append(str.substring(0, str.length()-1));
        return sb.toString();
    }

    private static String encoding(String str) {
        if(str.length() == 1) {return str;}

        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for(int i=0; i<str.length(); i++) {
            char currentChar = str.charAt(i);
            for(int j=i+1; j<str.length(); j++) {
                if(currentChar != str.charAt(j)) break;
                cnt++;  i++;
            }
            sb.append(currentChar);
            sb.append(cnt);
            cnt = 1;
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();

        int result = Integer.MAX_VALUE;
        String temp = A;

        for(int i=0; i<A.length(); i++) {
            result = Math.min(result, encoding(temp).length());
            temp = rightShift(temp);
        }
        System.out.println(result);
    }
}