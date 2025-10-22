import java.util.*;
public class Main {
    private static ArrayList<Character> operand;
    private static ArrayList<Character> operator;
    private static HashSet<Character> operandType;

    private static ArrayList<Integer> arr;

    private static int result = Integer.MIN_VALUE;

    private static int calculateValue() {
        ArrayList<Character> temp = new ArrayList<>(operandType);
        HashMap<Character, Integer> operandVal = new HashMap<>();

        for(int i=0; i<temp.size(); i++) {
            operandVal.put(temp.get(i), arr.get(i));
        }

        int idx = 0;
        int val = operandVal.get(operand.get(idx++));

        for(int i=0; i<operator.size(); i++) {
            char currOperator = operator.get(i);
            if(currOperator == '+') {
                val += operandVal.get(operand.get(idx++));
            } else if(currOperator == '-') {
                val -= operandVal.get(operand.get(idx++));
            } else if(currOperator == '*') {
                val *= operandVal.get(operand.get(idx++));
            }
        }

        return val;
    }

    private static void solution(int idx) {
        if(idx == operandType.size()) {
            int currVal = calculateValue();
            result = Math.max(result, currVal);
            return;
        }

        for(int num=1; num<=4; num++) {
            arr.add(num);
            solution(idx + 1);
            arr.remove(arr.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();

        operand = new ArrayList<>();
        operator = new ArrayList<>();
        operandType = new HashSet<>();

        arr = new ArrayList<>();

        for(int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if(i%2 == 0) {
                operand.add(c);
                operandType.add(c);
            } else {
                operator.add(c);
            }
        }

        solution(0);

        System.out.println(result);
        // Please write your code here.
    }
}