package graph.mst;

import graph.weightedGraph.CustomGraphs;
import graph.weightedGraph.Edge;
import graph.weightedGraph.Graph;
import graph.weightedGraph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LazyPrim {

    public static void main(String[] args) {
        LazyPrim lazyPrim = new LazyPrim(CustomGraphs.getCustomWeightedGraphForMst());

        for (Edge edge : lazyPrim.mst()) {
            System.out.println(edge.getFrom().getLabel() + " " + edge.getTo().getLabel() + "     " + edge.getWeight());
        }
    }

    private final Graph graph;

    public LazyPrim(Graph graph) {
        this.graph = graph;
    }

    public List<Edge> mst() {
        if (graph.getNodes().isEmpty()) return Collections.emptyList();

        List<Edge> mst = new ArrayList<>();
        List<Node> visited = new ArrayList<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));

        Node startNode = graph.getNodes().get(0);
        queue.addAll(startNode.getEdges());

        while (!queue.isEmpty()) {
            Edge currentEdge = queue.poll();
            visited.add(currentEdge.getFrom());

            if (visited.contains(currentEdge.getTo())) continue;

            mst.add(currentEdge);
            visited.add(currentEdge.getTo());
            for (Edge edge : currentEdge.getTo().getEdges()) {
                if (edge.getTo().isVisited())
                    continue;

                queue.add(edge);
            }
        }

        return mst;
    }

}
