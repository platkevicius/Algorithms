package graph.ordering;

import graph.unweightedGraph.CustomGraphs;
import graph.unweightedGraph.Graph;
import graph.unweightedGraph.Node;

import java.util.Stack;

public class TopologicalSort {

    private final Graph graph;

    public TopologicalSort(Graph graph) {
        this.graph = graph;
    }

    public Node[] sortTopological() {
        int n = graph.getNodes().size();

        int orderIndex = n-1;
        Node[] ordering = new Node[n];

        for (Node node : graph.getNodes()) {
            if (node.isVisited()) continue;

            orderIndex = dfs(node, orderIndex, ordering);
        }

        return ordering;
    }

    private int dfs(Node node, int orderIndex, Node[] ordering) {
        node.setVisited(true);

        for (Node neighbour : node.getNodes()) {
            if (neighbour.isVisited()) continue;
            orderIndex = dfs(neighbour, orderIndex, ordering);
        }

        ordering[orderIndex] = node;
        return orderIndex-1;
    }

    public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort(CustomGraphs.getCustomUnweightedGraphForTopSort());
        Node[] ordering = topologicalSort.sortTopological();

        for (Node node : ordering) {
            System.out.print(node.getLabel() + " ");
        }
    }

}
