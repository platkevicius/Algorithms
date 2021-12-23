package graph.traversal;

import graph.unweightedGraph.CustomGraphs;
import graph.unweightedGraph.Graph;
import graph.unweightedGraph.Node;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        breadthFirstSearch(CustomGraphs.getCustomUnweightedGraph1());
    }

    private static void breadthFirstSearch(Graph graph) {
        Queue<Node> queue = new LinkedList<>();
        Node startNode = graph.getNodes().get(0);

        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.isVisited()) continue;

            current.setVisited(true);

            System.out.println(current.getLabel());

            for (Node neighbour : current.getNodes()) {
                if (!neighbour.isVisited())
                    queue.offer(neighbour);
            }

        }

    }

}
