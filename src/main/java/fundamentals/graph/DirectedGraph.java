package fundamentals.graph;

public class DirectedGraph {
  public static void main(String[] args) {
    Node rafaelRootNode = createDirectedGraph();
    rafaelRootNode.showNodes();
  }

  public static Node createDirectedGraph() {
    Node rafaelRootNode = new Node("Rafael");
    Node brunoNode = new Node("Bruno");
    Node jamesNode = new Node("James Gosling");
    Node juggyNode = new Node("Juggy");
    Node dukeNode = new Node("Duke");
    Node johnNode = new Node("John");

    rafaelRootNode.addAdjacentNode(brunoNode);
    brunoNode.addAdjacentNode(rafaelRootNode);
    rafaelRootNode.addAdjacentNode(jamesNode);
    rafaelRootNode.addAdjacentNode(johnNode);
    rafaelRootNode.addAdjacentNode(dukeNode);
    jamesNode.addAdjacentNode(juggyNode);

    return rafaelRootNode;
  }
}
