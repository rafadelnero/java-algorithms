package fundamentals.graph;

public class UndirectedGraph {

  public static void main(String[] args) {
    Node rafaelRootNode = new Node("Rafael");
    Node brunoNode = new Node("Bruno");
    Node jamesNode = new Node("James Gosling");
    Node dukeNode = new Node("Duke");
    Node johnNode = new Node("John");

    rafaelRootNode.connect(brunoNode);
    rafaelRootNode.connect(johnNode);
    rafaelRootNode.connect(dukeNode);
    brunoNode.connect(jamesNode);

    rafaelRootNode.showNodes();
  }

}
