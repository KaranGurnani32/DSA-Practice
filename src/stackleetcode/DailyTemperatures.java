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

        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures.length - 1);
        answer[answer.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {

            int currentIndex = i;

            int currentTemp = temperatures[currentIndex];

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
