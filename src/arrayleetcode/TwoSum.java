package arrayleetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        Integer[] array = {2, 4, 6, 8, 10, 18, 13, 19}; // Input Array

        Integer target = 17; // Target

        Integer[] result = twoSum(array, target); // Result will be in array, and we want index not element

        printArray(result);
    }

    private static void printArray(Integer[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println();
    }

    private static Integer[] twoSum(Integer[] array, Integer target) {

        Map<Integer, Integer> map = new HashMap<>(); // Creating hashmap

        // Filling hashmap
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        // Searching hashmap
        for (int i = 0; i < array.length; i++) {

            int num = array[i]; // Taking first number of array

            int rem = target - num; // Taking another number which is the remaining of target - num

            if (map.containsKey(rem)) { // Checking if map has the remaining number
                int index = map.get(rem); // Grabbing the index of that number
                if (index == i) continue; // Continue is used when we want to skip next step and proceed to
                // next iteration of loop in this case if index == i then we will not execute the below
                // return statement and move to next iteration
                return new Integer[]{i, index}; // We will return array with index of first and second element
            }
        }
        return new Integer[]{};
    }

}
