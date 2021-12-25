package graph.shortestpath;

import graph.weightedGraph.CustomGraphs;
import graph.weightedGraph.Edge;
import graph.weightedGraph.Graph;
import graph.weightedGraph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstra {

    public static void main(String[] args) {
        List<Node> path = shortestPath(CustomGraphs.getCustomWeightedGraph1(), 1, 5);

        for (Node node : path) {
            System.out.println(node.getLabel());
        }
    }

    private static List<Node> shortestPath(Graph graph, int start, int destination) {
        // Initializing phase
        Node startNode = graph.getNodes().get(0);
        for (Node node : graph.getNodes()) {
            if (node.getLabel() == start) {
                node.setWeight(0);
                startNode = node;
                break;
            }
        }

        Queue<Node> openQueue = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        List<Node> closedSet = new ArrayList<>();
        openQueue.add(startNode);

        while (!openQueue.isEmpty()) {
            Node current = openQueue.poll();
            closedSet.add(current);

            // found Node
            if (current.getLabel() == destination)
                return buildPath(current);

            for (Edge neighbour : current.getEdges()) {
                if (closedSet.contains(neighbour.getTo())) continue;

                if (!openQueue.contains(neighbour.getTo())) openQueue.add(neighbour.getTo());

                if (neighbour.getTo().getWeight() > current.getWeight() + neighbour.getWeight()) {
                    neighbour.getTo().setWeight(current.getWeight() + neighbour.getWeight());
                    neighbour.getTo().setPredecessor(current);
                }
            }
        }

        // No path has been found
        return Collections.emptyList();
    }

    private static List<Node> buildPath(Node node) {
        List<Node> path = new ArrayList<>();

        Node current = node;
        while (current != null) {
            path.add(current);
            current = current.getPredecessor();
        }

        Collections.reverse(path);
        return path;
    }
}
