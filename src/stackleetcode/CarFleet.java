package stackleetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.*;

public class CarFleet {
    private static int carFleet(int target, int[] position, int[] speed) {
        double [] time = new double[position.length];
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < position.length; i++) {
            time[i] = ((double)target - position[i]) / speed[i];
        }

        Map<Integer, Double> positionTimeMap = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < position.length; i++) {
            positionTimeMap.put(position[i], time[i]);
        }
        System.out.println("positionTimeMap = " + positionTimeMap);
        for(Map.Entry<Integer, Double> entry: positionTimeMap.entrySet()) {
            System.out.println("stack = " + stack);
            Double currentTime = entry.getValue();
            if(stack.isEmpty()) {
                stack.push(currentTime);
            } else {
                if(stack.peek() < currentTime) {
                    stack.push(currentTime);
                }
            }
        }
        System.out.println("stack = " + stack);
        return stack.size();
    }

    public static void main(String[] args) {
        int target = 12;

        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};

        int output = carFleet(target, position, speed);
        System.out.println("output = " + output);
    }

//    private static int carFleet(int target, int[] position, int[] speed) {
//        int result = 0;
//        double[] timeArray = new double[target];
//        for (int i = 0; i < position.length; i++) {
////            System.out.println(position[i]);
////            System.out.println(target);
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
