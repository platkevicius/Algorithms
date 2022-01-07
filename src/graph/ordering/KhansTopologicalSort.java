package graph.ordering;

import graph.unweightedGraph.CustomGraphs;
import graph.unweightedGraph.Graph;
import graph.unweightedGraph.Node;
import graph.weightedGraph.Edge;

import java.util.LinkedList;
import java.util.Queue;

public class KhansTopologicalSort {

    private final Graph graph;

    public KhansTopologicalSort(Graph graph) {
        this.graph = graph;
    }

    public int[] topSort() {
        int n = graph.getNodes().size();

        int[] ordering = new int[n];
        int[] incoming = new int[n];

        int index = 0;
        Queue<Node> queue = new LinkedList<>();

        for (Node node : graph.getNodes()) {
            for (Node neighbour : node.getNodes()) {
                incoming[neighbour.getLabel() - 1] += 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (incoming[i] == 0) {
                queue.add(graph.getNodes().get(i));
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            ordering[index] = current.getLabel();
            index++;

            for (Node neighbour : current.getNodes()) {
                incoming[neighbour.getLabel() - 1] -= 1;

                if (incoming[neighbour.getLabel() - 1] == 0) queue.add(graph.getNodes().get(neighbour.getLabel() - 1));
            }

        }

        if (index != n)
            return new int[0];

        return ordering;
    }

    public static void main(String[] args) {
        KhansTopologicalSort khansTopologicalSort = new KhansTopologicalSort(CustomGraphs.getCustomUnweightedGraphForTopSort());

        for (int i : khansTopologicalSort.topSort())
            System.out.print(i + " ");
    }

}
