package graph.scc;

import graph.unweightedGraph.CustomGraphs;
import graph.unweightedGraph.Graph;
import graph.unweightedGraph.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Tarjan {

    private final Graph graph;

    Stack<Node> stack = new Stack<>();
    List<Node> visited = new ArrayList<>();
    private int amount = 0;

    public Tarjan(Graph graph) {
        this.graph = graph;
    }

    public int findSccAmount() {
        int sccAmount = 0;

        for (Node node : graph.getNodes()) {
            if (!visited.contains(node)) {
               dfs(node);
            }
        }

        return amount;
    }

    private void dfs(Node node) {
        visited.add(node);
        node.setId(node.getLabel());

        stack.push(node);

        for (Node neighbour : node.getNodes()) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour);
                node.setId(Math.min(node.getId(), neighbour.getId()));
            } else if (stack.contains(neighbour))
                node.setId(Math.min(node.getId(), neighbour.getId()));
        }

        if (node.getId() == node.getLabel()) {
            for (Node current = stack.pop(); ; current = stack.pop()) {

                current.setId(node.getId());

                if (current.equals(node)) {
                    amount++;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Tarjan tarjan = new Tarjan(CustomGraphs.getCustomUnweightedGraphForScc());

        System.out.println(tarjan.findSccAmount());
    }

}
