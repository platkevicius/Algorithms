package graph.mst;

import graph.weightedGraph.CustomGraphs;
import graph.weightedGraph.Edge;
import graph.weightedGraph.Graph;
import graph.weightedGraph.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EagerPrim {

    public static void main(String[] args) {
        EagerPrim eagerPrim = new EagerPrim(CustomGraphs.getCustomWeightedGraphForMst());

        for (Edge edge : eagerPrim.mst()) {
            System.out.println(edge.getFrom().getLabel() + " " + edge.getTo().getLabel() + "     " + edge.getWeight());
        }
    }

    private final HashMap<Node, Edge> ipq = new HashMap<>();
    private final List<Node> visited = new ArrayList<>();

    private final Graph graph;

    public EagerPrim(Graph graph) {
        this.graph = graph;
    }

    // not real implementation of the eager algorithm! A hashmap has been used instead of a indexed priority queue, hence it also does not come with the juicy efficiency!
    // still the algorithm with its idea is correctly implemented
    public List<Edge> mst() {
        List<Edge> mst = new ArrayList<>();
        relaxAllEdges(graph.getNodes().get(0));

        while (!ipq.isEmpty() && mst.size() != graph.getNodes().size()-1) {
            Node bestNode = null;
            Edge minEdge = new Edge(new Node(-1), new Node(-1), Integer.MAX_VALUE);

            for (Node node : ipq.keySet()) {
                if (ipq.get(node).getWeight() < minEdge.getWeight()) {
                    bestNode = node;
                    minEdge = ipq.get(node);
                }
            }

            ipq.remove(bestNode);
            mst.add(minEdge);

            relaxAllEdges(bestNode);
        }
        
        return mst;
    }

    private void relaxAllEdges(Node node) {
        visited.add(node);

        for (Edge edge : node.getEdges()) {

            if (visited.contains(edge.getTo()))
                continue;

            if (!ipq.containsKey(edge.getTo())) {
                ipq.put(edge.getTo(), edge);
            } else {
                if (edge.getWeight() < ipq.get(edge.getTo()).getWeight())
                    ipq.put(edge.getTo(), edge);
            }
        }
    }
}
