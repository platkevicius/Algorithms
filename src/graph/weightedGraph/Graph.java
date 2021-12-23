package graph.weightedGraph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private final List<Node> nodes = new ArrayList<>();

    public List<Node> getNodes() {
        return nodes;
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
