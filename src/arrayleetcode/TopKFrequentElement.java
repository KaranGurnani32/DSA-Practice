package arrayleetcode;

import java.util.*;

public class TopKFrequentElement {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9};

        int numberOfFreqElement = 2;

        List<Integer> FreqElements = topFreqElements(array, numberOfFreqElement);

        System.out.println(FreqElements);
    }


    private static List<Integer> topFreqElements(int[] array, int numberOfFreqElement) {
        // Creating a hashmap to store frequencies of element
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        Queue<Node> maxHeap = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < numberOfFreqElement; i++) {
            result.add(maxHeap.poll().number);
        }

        return result;

    }
}

class Node implements Comparable<Node> {

    Integer number;

    Integer frequency;

    public Node(Integer number, Integer frequency) {
        this.number = number;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node that) {
        return that.frequency - this.frequency;
    }
}
