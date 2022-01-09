package graph.eulerianPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EulerPath {

    private final int n;
    private int edgeCount;
    private int[] in, out;
    private LinkedList<Integer> path;
    private List<List<Integer>> graph;

    public EulerPath(List<List<Integer>> graph) {
        if (graph == null) throw new IllegalArgumentException("Graph cannot be null");
        n = graph.size();
        this.graph = graph;
        path = new LinkedList<>();
    }

    public int[] getEulerianPath() {
        setup();

        if(!hasEulerianPath()) return null;
        dfs(findStartNode());

        int[] sol = new int[edgeCount + 1];

        for (int i = 0; i < path.size(); i++) {
            sol[i]= path.get(i);
        }

        return sol;
    }

    private void dfs(int at) {
        while(out[at] != 0) {
            int next = graph.get(at).get(--out[at]);
            dfs(next);
        }

        path.addFirst(at);
    }

    private int findStartNode() {
        int startNode = 0;

        for (int i = 0; i < graph.size(); i++) {
            if (out[i] - in[i] == 1)
                return i;

            startNode = i;
        }

        return startNode;
    }

    private boolean hasEulerianPath() {
        if (edgeCount == 0) return false;

        int startNode = 0, endNode = 0;
        for (int i = 0; i < graph.size(); i++) {
            if (in[i] - out[i] == 1)
                endNode++;
            else if(out[i] - in[i] == 1)
                startNode++;
            else if(in[i] - out[i] != 0)
                return false;
        }

        return (startNode == 1 && endNode == 1) ||
               (startNode == 0 && endNode == 0);
    }

    private void setup() {
        in = new int[n];
        out = new int[n];

        edgeCount = 0;

        for (int from = 0; from < n; from++) {
            for (int to : graph.get(from)) {
                in[to]++;
                out[from]++;
                edgeCount++;
            }
        }
    }

    /* Graph helper Methods */
    private static List<List<Integer>> initializeEmptyGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        return graph;
    }

    private static void addDirectedEdge(List<List<Integer>> g, int from, int to) {
        g.get(from).add(to);
    }

    public static void main(String[] args) {
        int n = 7;
        List<List<Integer>> graph = initializeEmptyGraph(n);

        addDirectedEdge(graph, 1, 2);
        addDirectedEdge(graph, 1, 3);
        addDirectedEdge(graph, 2, 2);
        addDirectedEdge(graph, 2, 4);
        addDirectedEdge(graph, 2, 4);
        addDirectedEdge(graph, 3, 1);
        addDirectedEdge(graph, 3, 2);
        addDirectedEdge(graph, 3, 5);
        addDirectedEdge(graph, 4, 3);
        addDirectedEdge(graph, 4, 6);
        addDirectedEdge(graph, 5, 6);
        addDirectedEdge(graph, 6, 3);

        EulerPath solver = new EulerPath(graph);

        System.out.println(Arrays.toString(solver.getEulerianPath()));
    }

}
