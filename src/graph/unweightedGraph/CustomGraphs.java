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

    public static Graph getCustomUnweightedGraphForTopSort() {
        Graph graph = new Graph();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);

        node1.addNode(node4);

        node2.addNode(node4);

        node3.addNode(node1);
        node3.addNode(node2);

        node4.addNode(node7);
        node4.addNode(node8);

        node5.addNode(node1);
        node5.addNode(node4);
        node5.addNode(node6);

        node6.addNode(node10);
        node6.addNode(node11);

        node7.addNode(node9);

        node8.addNode(node9);
        node8.addNode(node10);

        node9.addNode(node12);

        node10.addNode(node12);
        node10.addNode(node13);

        node11.addNode(node10);

        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);
        graph.addNode(node8);
        graph.addNode(node9);
        graph.addNode(node10);
        graph.addNode(node11);
        graph.addNode(node12);
        graph.addNode(node13);


        return graph;
    }


}
