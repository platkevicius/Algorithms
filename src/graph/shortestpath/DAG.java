package graph.shortestpath;

import graph.ordering.KhansTopologicalSort;
import graph.weightedGraph.Edge;
import graph.weightedGraph.Graph;
import graph.weightedGraph.Node;

import java.util.Arrays;

public class DAG {

    private final Graph graph;
    private KhansTopologicalSort topSort;

    public DAG(Graph graph) {
        this.graph = graph;
        //topSort = new KhansTopologicalSort(graph);
    }

    public int[] shortestPath(int vertex) {
        Node start = null;
        for (Node node : graph.getNodes()) {
            if (node.getLabel() == vertex) {
                start = node;
                break;
            }
        }

        if (start == null)
            return new int[0];

        int[] ordering = topSort.topSort();
        int[] distances = new int[graph.getNodes().size()];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[vertex] = 0;

        for (int i = vertex; i < ordering.length; i++) {
            Node current = graph.getNodes().get(i);

            for (Edge edge : current.getEdges()) {
                if (distances[edge.getTo().getLabel()-1] > edge.getWeight() + distances[vertex])
                    distances[edge.getTo().getLabel() - 1] = edge.getWeight() + distances[vertex];
            }
        }

        return distances;
    }

}
