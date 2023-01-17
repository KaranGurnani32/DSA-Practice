package arrayleetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        // Input Array
        Integer[] array = {2, 4, 6, 8, 10, 18, 13, 19};

        // Target
        Integer target = 17;

        // Result will be in array, and we want index not element
        Integer[] result = twoSum(array, target);

        printArray(result);
    }

    private static void printArray(Integer[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
        System.out.println();
    }

    private static Integer[] twoSum(Integer[] array, Integer target) {

        // Creating hashmap
        Map<Integer, Integer> map = new HashMap<>();

        // Filling hashmap
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }

        // Searching hashmap
        for (int i = 0; i < array.length; i++) {

            // Taking first number of array
            int num = array[i];

            // Taking another number which is the remaining of target - num
            int rem = target - num;

            // Checking if map has the remaining number
            if (map.containsKey(rem)) {
                // Grabbing the index of that number
                int index = map.get(rem);
                // Continue is used when we want to skip next step and proceed to
                // next iteration of loop in this case if index == i then we will not execute the below
                // return statement and move to next iteration
                if (index == i) continue;
                // We will return array with index of first and second element
                return new Integer[]{i, index};
            }
        }
        return new Integer[]{};
    }

}
