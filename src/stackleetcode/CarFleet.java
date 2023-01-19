package stackleetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
        int target = 10;

        int[] position = {6,8};
        int[] speed = {3,2};

        int output = carFleet(target, position, speed);
        System.out.println("output = " + output);
    }

    private static int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[position.length];

        for (int i = 0; i < position.length; i++) {
            time[i] = ((double) target - position[i]) / speed[i];

        }
        Stack<Double> stack = new Stack<>();
        stack.push(time[0]);
        int count = 0;
        for (int i = 1; i < time.length; i++) {
            System.out.println(stack);
            if (time[i] > stack.peek()) {
                stack.push(time[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() >= time[i]) {
                    stack.pop();
                    count++;
                }
                stack.push(time[i]);
            }
        }
        if (count == 0) {
            return 1;
        } else if (count == 1) {
            return count + 1;
        } else {
            return count;
        }
    }

//    private static int carFleet(int target, int[] position, int[] speed) {
//        int result = 0;
//        double[] timeArray = new double[target];
//        for (int i = 0; i < position.length; i++) {
//            timeArray[position[i]] = (double) (target - position[i]) / speed[i];
//        }
//
//        double previous = 0.0;
//        for (int i = target - 1; i >= 0; i--) {
//            double current = timeArray[i];
//            if (current > previous) {
//                previous = current;
//                result++;
//            }
//        }
//        return result;
//    }

}
