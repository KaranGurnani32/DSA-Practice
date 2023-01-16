package stackleetcode;

import java.util.Stack;

public class ValidParentheses {
//    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//    An input string is valid if:
//
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.
//    Every close bracket has a corresponding open bracket of the same type.
    public static void main(String[] args) {
        String input = "(){}[]";
        Boolean result = isValid(input);

        System.out.println("result = " + result);
    }

    private static Boolean isValid(String input) {

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {

            //check ch
            switch (ch) {

                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
