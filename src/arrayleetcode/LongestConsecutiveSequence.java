package arrayleetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    /*
    * To check this we can check which elements could be starting point
    * Taking those points we need to check for longest sequence
    * */
    public static void main(String[] args) {
        int[] array = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(array);

        System.out.println("result = " + result);
    }

    private static int longestConsecutive(int[] array) {

        // Creating set
        Set<Integer> set = new HashSet<>();

        // Adding all elements to set
        for (int element : array) {
            set.add(element);
        }


        // Creating an int for checking which is the overall max
        int overAllMax = 0;

        // Iterating through array
        for (int element : array) {
            // Checking if array contains the value one less than element
            if (!set.contains(element - 1)) {
                // Creating an int for current max
                int currentMax = 1;
                // If element has consecutive increasing values we will increase current max
                while (set.contains(element + currentMax)) {
                    currentMax++;
                }
                // Current max will be our overall max if currentMax > overAllMax
                if (currentMax > overAllMax) {
                    overAllMax = currentMax;
                }
            }
        }
        return overAllMax;
    }

//    This method has time complexity of O(n) but leetcode not accepting hence optimized soln is above
//    private static int longestConsecutive(int[] array) {
//
//        Map<Integer, Boolean> map = new HashMap<>();
//
//        // Putting all values as true
//        for (int i = 0; i < array.length; i++) {
//            map.put(array[i], true);
//        }
//
//        // If element has a number smaller than it then its false as it cannot be a starting point of sequence
//        for (int i = 0; i < array.length; i++) {
//            if (map.containsKey(array[i] - 1)) {
//                map.put(array[i], false);
//            }
//        }
//
//        // Taking a point of reference for maxLength and maxStartingPoint
//        int maxLength = 0;
//        int maxStartingPoint = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if (map.get(array[i]) == true) { // Check for elements who can be starting point of Sequence
//
//                int tempLength = 1; // There is only 1 element at the moment hence tempLength = 1
//                int tempStartingPoint = array[i]; // Starting point would be the element which is true
//
//                while (map.containsKey(tempLength + tempStartingPoint)) { // If map has element
//                    // which is consecutive to startingPoint element then we can increase the length
//                    // this way we will get the total length of sequence
//                    tempLength++;
//                }
//
//                if (tempLength > maxLength) { // We can update the length now to the maxLength and
//                    // maxStarting point if tempLength
//                    // (which we are currently analyzing > maxLength(which we have stored previously)
//                    maxStartingPoint = tempStartingPoint;
//                    maxLength = tempLength;
//                }
//
//            }
//        }
//        return maxLength;
//    }
}
