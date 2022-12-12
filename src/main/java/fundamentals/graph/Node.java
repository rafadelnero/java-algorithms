package fundamentals.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

  Object value;
  private List<Node> adjacentNodes = new ArrayList<>();
  private boolean visited;

  public Node(Object value) {
    this.value = value;
  }

  public void addAdjacentNode(Node node) {
    this.adjacentNodes.add(node);
  }

  public void connect(Node node) {
    if (this == node) throw new IllegalArgumentException("Can't connect node to itself");
    this.adjacentNodes.add(node);
    node.adjacentNodes.add(this);
  }

  public List<Node> getAdjacentNodes() {
    return adjacentNodes;
  }

  public void showNodes() {
    BreathFirstSearchPrintNodes.printNodes(this);
  }

  public Object getValue() {
    visited = true;
    return value;
  }

  public boolean isVisited() {
    return visited;
  }
}
