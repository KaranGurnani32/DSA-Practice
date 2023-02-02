package stackleetcode;

import java.util.Arrays;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int maxArea = largestRectangleArea(heights);
//        System.out.println("MaxArea = " + maxArea);
    }

    private static int largestRectangleArea(int[] heights) {
        int[] left = leftArray(heights);
        int[] right = rightArray(heights);
//        int[] result = rightArray(heights);
        int maxArea = 0;
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        return maxArea;
    }

    private static int[] rightArray(int[] heights) {
        int[] right = new int[heights.length];

        right[heights.length - 1]= 0;

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] > heights[i]) {
                    count++;
                } else {
                    break;
                }
            }
            right[i] = count;
        }
        return right;
    }

    private static int[] leftArray(int[] heights) {
        int[] left = new int[heights.length];

        left[0]= 0;

        int count = 0;
        for (int i = 1; i < heights.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    count++;
                } else {
                    break;
                }
            }
            left[i] = count;
        }
        return left;
    }
}
