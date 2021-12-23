package graph.weightedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Node {

    int label;
    private boolean visited;
    private final List<Edge> edges = new ArrayList<>();

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
