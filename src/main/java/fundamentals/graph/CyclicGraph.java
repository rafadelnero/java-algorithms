package fundamentals.graph;

public class CyclicGraph {
  public static void main(String[] args) {
    Node dukeNode = new Node("Duke");
    Node mobyDockNode = new Node("Moby Dock");
    Node juggyNode = new Node("Juggy");

    dukeNode.addAdjacentNode(mobyDockNode);
    mobyDockNode.addAdjacentNode(juggyNode);
    juggyNode.addAdjacentNode(dukeNode);

    dukeNode.showNodes();
  }
}
