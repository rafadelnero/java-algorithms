package fundamentals.graph;

public class AcyclicGraph {

  public static void main(String[] args) {
    Node dukeRootNode = new Node("Duke");
    Node mozillaNode = new Node("Mozilla");
    Node mobyDockNode = new Node("Moby Dock");
    Node juggyNode = new Node("Juggy");

    dukeRootNode.addAdjacentNode(mozillaNode);
    dukeRootNode.addAdjacentNode(mobyDockNode);
    dukeRootNode.addAdjacentNode(juggyNode);
    dukeRootNode.showNodes();
  }
}
