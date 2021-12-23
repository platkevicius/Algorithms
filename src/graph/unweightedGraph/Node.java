package graph.unweightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

    private final int label;
    private boolean visited;
    private final List<Node> nodes = new ArrayList<>();

    public Node(int label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public int getLabel() {
        return label;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return label == node.label &&
               visited == node.visited &&
               Objects.equals(nodes, node.nodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, visited, nodes);
    }
}
