package graph.weightedGraph;

import java.util.Objects;

public class Edge {

    private final Node from;
    private final Node to;
    private final int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Node getTo() {
        return to;
    }

    public Node getFrom() {
        return from;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return weight == edge.weight &&
               Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, weight);
    }
}
