package graph;

import java.util.Objects;

public class Node {
    String data;

    public Node(String data) { // Creating parameterized constructor to initialize data
        this.data = data;      // We make constructor, so we don't have to use getters and setters
    }

    @Override
    public String toString() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return data.equals(node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
