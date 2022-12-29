package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenericGraph {
    /*
     * Make adjacency list, choose data type acc to question
     * Add default constructor
     * Creating method to add edges
     * printing the list
     * Creating main method and adding edges
     * To further make it a weighted graph we need to declare another variable
     * In this the edges are not same
     * We need to initialize it in constructor
     * make code for weighted edges
     * add code for printing it
     * */
    Map<Node, List<Node>> adjacencyList; // We use Map and not arraylist because in arraylist
    // we can only represent integers and not String
    // In order to use arraylist in this case we can make a dictionary and represent the
    // String in indexes

    Map<Edge, Integer> cost; // Taking a Map so it is easy to represent String

    public GenericGraph() {
        this.adjacencyList = new HashMap<>(); // Initializing adjacencyList
        this.cost = new HashMap<>();
    }

    void addEdges(String sourceString, String destinationString, Integer weight) { // Creating new method to add edge
        //with 2 String parameters instead of adding new node in main method
        Node source = new Node(sourceString); // Creating a node of source
        Node destination = new Node(destinationString); // Creating a node of destination
        if (adjacencyList.containsKey(source)){ //Checking if adjacencyList contains source
            adjacencyList.get(source).add(destination); // If it contains source then we will connect
            // source with destination
        } else { // otherwise we will add source with use of put method in hashmap
            adjacencyList.put(source, new LinkedList<>()); // here we add a new linked list where
            // value of source is put in index
            adjacencyList.get(source).add(destination); // we will connect source with destination
        }

        Edge edge = new Edge(source, destination); // Initializing edge
        cost.put(edge, weight); // adding the weight b/w source and destination node
    }

    void printAdjacencyList() { // Here we need to print adjacencyList which is a HashMap

        for (Map.Entry<Node,List<Node>> entry : adjacencyList.entrySet()){
            Node key = entry.getKey();
            StringBuilder valueString = new StringBuilder();
            for (Node value : entry.getValue()) {
                valueString.append(value).append("(").append(cost.get(new Edge(key, value))).append("), ");
            }
            System.out.println(key + " --> " + valueString);
        }
    }

    public static void main(String[] args) {
        GenericGraph graph = new GenericGraph();

//        graph.addEdges("Karan", "Kanishk");
//        graph.addEdges("Karan", "DJ");
//        graph.addEdges("Karan", "Chintu");
//        graph.addEdges("Karan", "Akkshay");
//        graph.addEdges("Karan", "Radhicka");
//        graph.addEdges("Kanishk", "Radhicka");
//        graph.addEdges("Kanishk", "DJ");
//        graph.addEdges("Kanishk", "Pragati");
//        graph.addEdges("DJ", "Kanishk");
//        graph.addEdges("DJ", "Karan");
//        graph.addEdges("DJ", "Pragati");
//        graph.addEdges("Chintu", "Karan");
//        graph.addEdges("Chintu", "Akkshay");
//        graph.addEdges("Akkshay", "Karan");
//        graph.addEdges("Akkshay", "Chintu");
//        graph.addEdges("Radhicka", "Kanishk");
//        graph.addEdges("Radhicka", "Pragati");
//        graph.addEdges("Pragati", "Radhicka");
//        graph.addEdges("Pragati", "Kanishk");

        graph.addEdges("Rithala","Rohini West", 5);
        graph.addEdges("Rohini West","Rohini East", 10);
        graph.addEdges("Rohini East","Peeragadhi", 25);
        graph.addEdges("Peeragadhi","Paschim Vihar", 15);
        graph.addEdges("Paschim Vihar","Karol Bagh", 20);

        graph.printAdjacencyList();
    }
}
