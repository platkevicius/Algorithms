package graph.mst;

import ds.UnionFind;
import graph.weightedGraph.CustomGraphs;
import graph.weightedGraph.Edge;
import graph.weightedGraph.Graph;
import graph.weightedGraph.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Kruskal {

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal(CustomGraphs.getCustomWeightedGraphForMst());

        for (Edge edge : kruskal.mst()) {
            System.out.println(edge.getFrom().getLabel() + " " + edge.getTo().getLabel() + "     " + edge.getWeight());
        }
    }

    private final Graph graph;

    public Kruskal(Graph graph) {
        this.graph = graph;
    }

    public List<Edge> mst() {
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparing(Edge::getWeight));
        List<Edge> mst = new ArrayList<>();

        for (Node node : graph.getNodes())
            edges.addAll(node.getEdges());

        UnionFind unionFind = new UnionFind(graph.getNodes().size());

        for (Edge edge : edges) {
            Node from = edge.getFrom();
            Node to = edge.getTo();

            if (!unionFind.isConnected(from.getLabel() - 1, to.getLabel() - 1))
                mst.add(edge);

            unionFind.unify(from.getLabel() - 1, to.getLabel() - 1);
        }

        return mst;
    }

}
