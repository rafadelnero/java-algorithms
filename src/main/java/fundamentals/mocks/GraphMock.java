package fundamentals.mocks;

import fundamentals.graph.Node;

public class GraphMock {

  public static Node createDfsMock() {
    Node rootNode = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);

    rootNode.addAdjacentNode(node2);
    node2.addAdjacentNode(node3);
    node3.addAdjacentNode(node4);
    node4.addAdjacentNode(node5);

    rootNode.addAdjacentNode(node6);
    node6.addAdjacentNode(node7);

    return rootNode;
  }

  public static Node createBfsMock() {
    Node rootNode = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    Node node7 = new Node(7);
    Node node8 = new Node(8);

    rootNode.addAdjacentNode(node2);
    rootNode.addAdjacentNode(node3);
    node2.addAdjacentNode(node4);
    node2.addAdjacentNode(node5);
    node4.addAdjacentNode(node2);
    node5.addAdjacentNode(node7);
    node5.addAdjacentNode(node8);

    rootNode.addAdjacentNode(node3);
    node3.addAdjacentNode(node6);

    return rootNode;
  }
}
