package graph.unweightedGraph;

public class CustomGraphs {

    public static Graph getCustomUnweightedGraph1() {
        Graph graph = new Graph();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.addNode(node4);
        node1.addNode(node3);
        node1.addNode(node2);

        node4.addNode(node5);
        node3.addNode(node5);
        node2.addNode(node5);

        node5.addNode(node7);
        node5.addNode(node6);

        node6.addNode(node8);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);
        graph.addNode(node8);

        return graph;
    }

}