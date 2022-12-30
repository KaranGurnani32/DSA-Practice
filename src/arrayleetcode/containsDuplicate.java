package arrayleetcode;

import java.util.*;

public class containsDuplicate {

    public static void main(String[] args) {
        Integer[] array = {2, 3, 1, 7, 13, 11, 1};

        Boolean result = duplicateElement(Arrays.stream(array).toList()); // Taken result as boolean
        // Converted array to stream then to List
        // Arrays.stream(array).toList() -> This is just a way to convert array to list, we can
        // directly convert array to list in set using Arrays.asList(array)
        System.out.println("result = " + result);
    }
    static Boolean duplicateElement(List<Integer> input) { // Created method to check duplicate element
        // in array, we have taken list as input, so it is easy to add in set

        Set<Integer> set = new HashSet<>(input); // Creating set because in set we cannot have duplicate values

        return set.size() != input.size(); // If set and array size not similar then return true which means
        // there is one value which appears twice and vice versa
    }
}
