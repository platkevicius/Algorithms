package graph.traversal;

import graph.unweightedGraph.CustomGraphs;
import graph.unweightedGraph.Graph;
import graph.unweightedGraph.Node;

import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        depthFirstSearch(CustomGraphs.getCustomUnweightedGraph1());
    }

    private static void depthFirstSearch(Graph graph) {
        Stack<Node> stack = new Stack<>();
        Node startNode = graph.getNodes().get(0);

        stack.push(startNode);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            current.setVisited(true);
            System.out.println(current.getLabel());

            for (Node neighbour : current.getNodes()) {
                if (!neighbour.isVisited())
                    stack.push(neighbour);
            }
        }

    }

}
