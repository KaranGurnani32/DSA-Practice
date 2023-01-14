package arrayleetcode;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};

        int[] result = productExceptSelf(array);

        System.out.println(Arrays.toString(result));
    }

    private static int[] productExceptSelf(int[] array) {

        int lengthOfArray = array.length;
//        int[] leftPass = new int[lengthOfArray];
//        int[] rightPass = new int[lengthOfArray];

//        leftPass[0] = 1;
//        rightPass[lengthOfArray - 1] = 1;
        int[] result = new int[lengthOfArray];

        for (int i = 1; i < lengthOfArray; i++) {
            result[i] = array[i - 1] * result[i - 1];
        }
//        System.out.println(Arrays.toString(result));

        int right = 1;
        for (int i = lengthOfArray - 1; i >= 0 ; i--) {
            result[i] = array[i + 1] * right;
            right = right * array[i];
        }
//        System.out.println(Arrays.toString(rightPass));

//        for (int i = 0; i < lengthOfArray; i++) {
//            result[i] = result[i] * rightPass[i];
//        }

        return result;

    }
}
