package arrayleetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Stream {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 5};
        printArray(a);

        List<Integer> s = Arrays.stream(a).toList(); // Converting array to List
        System.out.println(s);
    }

    private static void printArray(Integer[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
}
