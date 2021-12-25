package graph.weightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    int label;
    private boolean visited = false;
    private final List<Edge> edges = new ArrayList<>();

    private Node predecessor;

    private int weight = Integer.MAX_VALUE;

    public Node(int label) {
        this.label = label;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public int getLabel() {
        return label;
    }

    public Node getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Node predecessor) {
        this.predecessor = predecessor;
    }

    public boolean isVisited() {
        return visited;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return label == node.label &&
               visited == node.visited &&
               Objects.equals(edges, node.edges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, visited, edges);
    }
}
