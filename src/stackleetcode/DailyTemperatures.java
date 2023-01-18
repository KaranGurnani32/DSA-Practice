package stackleetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        int[] answer = dailyTemperatures(temperatures);

        System.out.println(Arrays.toString(answer));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        // We made an answer array which contains the output
        int[] answer = new int[temperatures.length];

        // We created a stack
        Stack<Integer> stack = new Stack<>();

        // We pushed the last index in this case 9 into stack
        stack.push(temperatures.length - 1);
        // The last element of answer would be zero as there is no other element present after last element
        answer[answer.length - 1] = 0;

        // Starting a for loop from second last index of temp array
        for (int i = temperatures.length - 2; i >= 0; i--) {

            // We take an integer currentIndex which holds the value of i
            int currentIndex = i;

            // We take an integer currentTemp which holds value of temp at currentIndex
            int currentTemp = temperatures[currentIndex];

            // If currentTemp < temperatures[stack.peek()]
            if (currentTemp < temperatures[stack.peek()]) {
                answer[i] = stack.peek() - currentIndex;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && currentTemp >= temperatures[stack.peek()]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    answer[i] = 0;
                    stack.push(i);
                } else {
                    answer[i] = stack.peek() - currentIndex;
                    stack.push(i);
                }
            }
        }
        return answer;
    }

    //Brute Force
//    private static int[] dailyTemperatures(int[] temperatures) {
//
//        int[] answer = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            for (int j = i + 1; j < temperatures.length; j++) {
//                if (temperatures[i] < temperatures[j]) {
//                    answer[i] = j - i;
//                } else {
//                    continue;
//                }
//                break;
//            }
//        }
//
//        return answer;
//    }


}
