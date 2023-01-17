package stackleetcode;

import java.util.Stack;

public class EvaluateReversePolish {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

        Integer output = evalRPN(tokens);

        System.out.println("output = " + output);
    }

    private static Integer evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/") {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                Integer lastNumber = stack.pop();
                Integer secondLastNumber = stack.pop();
                Integer result = help(lastNumber, secondLastNumber, tokens[i]);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    private static Integer help(Integer lastNumber, Integer secondLastNumber, String token) {
        if (token.equals("+")) return secondLastNumber + lastNumber;
        else if (token.equals("-")) return secondLastNumber - lastNumber;
        else if (token.equals("*")) return secondLastNumber * lastNumber;
        return secondLastNumber / lastNumber;

    }
}
