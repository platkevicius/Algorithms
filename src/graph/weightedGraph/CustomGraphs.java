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
        v1.addEdge(new Edge(v1, v2, 1)); //connect v1 v2
        v2.addEdge(new Edge(v2, v1, 1));

        v2.addEdge(new Edge(v2, v3, 2)); //connect v2 v3
        v3.addEdge(new Edge(v3, v2, 2));

        v2.addEdge(new Edge(v2, v4, 3)); //connect v2 v4
        v4.addEdge(new Edge(v4, v2, 3));

        v4.addEdge(new Edge(v4, v5, 1)); //connect v4 v5
        v5.addEdge(new Edge(v5, v4, 1));

        graph.addNode(v1);
        graph.addNode(v2);
        graph.addNode(v3);
        graph.addNode(v4);
        graph.addNode(v5);

        return graph;
    }

    public static Graph getCustomWeightedGraphForMst() {
        Graph graph = new Graph();

        //construct vertices
        Node v1 = new Node(1);
        Node v2 = new Node(2);
        Node v3 = new Node(3);
        Node v4 = new Node(4);
        Node v5 = new Node(5);
        Node v6 = new Node(6);
        Node v7 = new Node(7);
        Node v8 = new Node(8);

        //to make the graph un directed use the same weight
        //both ways
        v1.addEdge(new Edge(v1, v2, 5)); //connect v1 v2
        v2.addEdge(new Edge(v2, v1, 5));

        v1.addEdge(new Edge(v1, v3, 4));
        v3.addEdge(new Edge(v3, v1, 4));

        v2.addEdge(new Edge(v2, v5, 3)); //connect v2 v3
        v5.addEdge(new Edge(v5, v2, 3));

        v3.addEdge(new Edge(v3, v4, 2));
        v3.addEdge(new Edge(v4, v3, 2));

        v4.addEdge(new Edge(v4, v5, 1));
        v5.addEdge(new Edge(v5, v4, 1));

        v4.addEdge(new Edge(v4, v8, 3));
        v8.addEdge(new Edge(v8, v4, 3));

        v5.addEdge(new Edge(v5, v6, 3));
        v6.addEdge(new Edge(v6, v5, 3));

        v5.addEdge(new Edge(v5, v7, 10));
        v7.addEdge(new Edge(v7, v5, 10));

        v6.addEdge(new Edge(v6, v7, 3));
        v7.addEdge(new Edge(v7, v6, 3));

        v7.addEdge(new Edge(v7, v8, 2));
        v8.addEdge(new Edge(v8, v7, 2));

        graph.addNode(v1);
        graph.addNode(v2);
        graph.addNode(v3);
        graph.addNode(v4);
        graph.addNode(v5);
        graph.addNode(v6);
        graph.addNode(v7);
        graph.addNode(v8);

        return graph;
    }

}
