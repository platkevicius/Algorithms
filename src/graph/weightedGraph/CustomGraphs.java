package graph.weightedGraph;

public class CustomGraphs {

    public static Graph getCustomWeightedGraph1() {
        Graph graph = new Graph();

        //construct vertices
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);

        //to make the graph un directed use the same weight
        //both ways
        v1.addEdge(new Edge(v2, 1)); //connect v1 v2
        v2.addEdge(new Edge(v1, 1));

        v2.addEdge(new Edge(v3, 2)); //connect v2 v3
        v3.addEdge(new Edge(v2, 2));

        v2.addEdge(new Edge(v4, 3)); //connect v2 v4
        v4.addEdge(new Edge(v2, 3));

        v4.addEdge(new Edge(v5, 1)); //connect v4 v5
        v5.addEdge(new Edge(v4, 1));

        graph.addNode(v1);
        graph.addNode(v2);
        graph.addNode(v3);
        graph.addNode(v4);
        graph.addNode(v5);

        return graph;
    }

}
