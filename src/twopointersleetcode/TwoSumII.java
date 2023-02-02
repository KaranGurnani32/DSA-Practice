package twopointersleetcode;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] input = {2, 7, 11, 15};

        int target = 9;

        int[] result = twoSum(input, target);

        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSum(int[] input, int target) {
        int leftPointer = 0;
        int rightPointer = input.length - 1;


        while (leftPointer <= rightPointer) {
            if (input[leftPointer] + input[rightPointer] == target) {
                return new int[]{leftPointer + 1, rightPointer + 1};
            } else if (input[leftPointer] + input[rightPointer] < target) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }

        return new int[]{leftPointer + 1, rightPointer + 1};
    }
}


//    Brute Force
//    private static int[] twoSum(int[] input, int target) {
//        for (int i = 0; i < input.length; i++) {
//            for (int j = i + 1; j < input.length; j++) {
//                if (input[i] + input[j] == target) {
//                    return new int[]{i + 1, j + 1};
//                }
//            }
//        }
//        return new int[]{};
//    }
//}
