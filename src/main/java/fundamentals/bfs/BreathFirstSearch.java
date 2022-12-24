package fundamentals.bfs;

import fundamentals.dfs.TreeNode;
import fundamentals.graph.Node;
import fundamentals.mocks.TreeMock;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {

  public static void main(String[] args) {
//    bfsForGraph(GraphMock.createBfsMock());
    bfsForTree(TreeMock.createBfsMock());
  }

  public static void bfsForGraph(Node node) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      var currentNode = queue.poll();
      if (!currentNode.isVisited()) {
        System.out.print(currentNode.getValue() + " ");
        queue.addAll(currentNode.getAdjacentNodes());
      }
    }
  }

  public static void bfsForTree(TreeNode node) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);

    while (!queue.isEmpty()) {
      var currentNode = queue.poll();

      if (currentNode != null) {
        System.out.print(currentNode.value + " ");
        queue.add(currentNode.left);
        queue.add(currentNode.right);
      }
    }
  }

}
