package graph.shortestpath;

import graph.weightedGraph.CustomGraphs;
import graph.weightedGraph.Edge;
import graph.weightedGraph.Graph;
import graph.weightedGraph.Node;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord(CustomGraphs.getCustomWeightedGraphForMst());

        double[] distances = bellmanFord.find();
        for (double d : distances)
            System.out.println(d);
    }

    private final Graph graph;

    public BellmanFord(Graph graph) {
        this.graph = graph;
    }

    public double[] find() {
        int verticesSize = graph.getNodes().size();
        List<Edge> edges = new ArrayList<>();

        for (Node node : graph.getNodes())
            edges.addAll(node.getEdges());

        if (verticesSize == 0)
            return new double[0];

        double[] distances = new double[verticesSize];
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        distances[0] = 0;

        // initial relaxation
        // first for loop is to guarantee correct propagation second one for updating the edges in the distance array
        for (int i = 0; i < verticesSize - 1; i++) {
            for (Edge edge : edges) {
                distances[edge.getTo().getLabel() - 1] = Math.min(distances[edge.getTo().getLabel() - 1], distances[edge.getFrom().getLabel() - 1] + edge.getWeight());
            }
        }

        // second iteration is for detecting negative cycles
        for (int i = 0; i < verticesSize - 1; i++) {
            for (Edge edge : edges) {
                if (distances[edge.getTo().getLabel() - 1] > distances[edge.getFrom().getLabel() - 1] + edge.getWeight())
                distances[edge.getTo().getLabel() - 1] = Double.NEGATIVE_INFINITY;
            }
        }

        return distances;
    }

}
