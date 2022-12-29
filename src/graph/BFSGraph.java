package graph;

import java.util.*;

public class BFSGraph {
    /*
    For BFS, we take visited and result list for checking node is already visited or not
    -> Then we make a queue and then add a node and set it to visited
    -> Make a loop where node is pulled out of queue if queue is not empty
    -> If that node is not visited the add it to result and set its visit status as true
    -> If it is visited then add its neighbor to queue
    -> return the result
    -> Follow same steps for dfs just use stack instead of queue
     */
    Map<Node, List<Node>> adjacencyList;

    public BFSGraph() {
        this.adjacencyList = new HashMap<>();
    }

    void addEdge(Node source, Node destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).add(destination);
        } else {
            adjacencyList.put(source, new LinkedList<>());
            adjacencyList.get(source).add(destination);
        }
    }

    List<Node> bfs(Node source) {
        Set<Node> visited = new HashSet<>(); // We make a set for the node which has already been visited
        // We take set because set has a property in which same reference cannot be added again

        List<Node> result = new LinkedList<>(); // We make a linked list for result
        // We take linked list as insertion in linked list is faster than arraylist

        Queue<Node> queue = new LinkedList<>(); // We take queue so that we can get the values of graph
        // in FIFO as it helps us in getting breadth first search

        queue.offer(source); // adding a node into queue and not marking it as visited because
        // we have already taken set which has a property in which same reference cannot be added again

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (!visited.contains(current)) {
                visited.add(current);
                result.add(current);
            }
            for (Node neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    queue.add(neighbour);
                }
            }
        }
        return result;

    }

    void printAdjacencyList() { // Here we need to print adjacencyList which is a HashMap
        for (Map.Entry<Node,List<Node>> entry : adjacencyList.entrySet()){
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph();

        graph.addEdge(new Node("Karan"), new Node("Kanishk"));
        graph.addEdge(new Node("Karan"), new Node("Akkshay"));
        graph.addEdge(new Node("Karan"), new Node("DJ"));
        graph.addEdge(new Node("Karan"), new Node("Chintu"));
        graph.addEdge(new Node("Kanishk"), new Node("Pragati"));
        graph.addEdge(new Node("Kanishk"), new Node("DJ"));
        graph.addEdge(new Node("Kanishk"), new Node("Radhika"));
        graph.addEdge(new Node("Radhika"), new Node("Muskan"));
        graph.addEdge(new Node("Radhika"), new Node("Pragati"));
        graph.addEdge(new Node("Pragati"), new Node("Kanishk"));
        graph.addEdge(new Node("Pragati"), new Node("Karan"));
        graph.addEdge(new Node("DJ"), new Node("Karan"));
        graph.addEdge(new Node("DJ"), new Node("Kanishk"));
        graph.addEdge(new Node("DJ"), new Node("Pragati"));
        graph.addEdge(new Node("Akkshay"), new Node("Karan"));
        graph.addEdge(new Node("Akkshay"), new Node("Kanishk"));
        graph.addEdge(new Node("Akkshay"), new Node("Chintu"));
        graph.addEdge(new Node("Chintu"), new Node("Karan"));
        graph.addEdge(new Node("Muskan"), new Node("Karan"));

//        graph.printAdjacencyList();

        System.out.println(graph.bfs(new Node("Karan")));
    }
}
