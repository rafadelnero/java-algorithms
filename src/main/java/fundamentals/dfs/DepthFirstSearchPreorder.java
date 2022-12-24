package fundamentals.dfs;

import fundamentals.graph.Node;
import fundamentals.mocks.GraphMock;
import fundamentals.mocks.TreeMock;
import java.util.Stack;

public class DepthFirstSearchPreorder {

  public static void main(String[] args) {
    Node rootNode = GraphMock.createDfsMock();
//    dfsRecursiveWithoutLambda(rootNode);
    dfsRecursiveBinaryTree(TreeMock.createTreeMock());
  }

  public static void dfsRecursive(Node node) {
    System.out.print(node.getValue() + " ");
    node.getAdjacentNodes().stream()
        .filter(n -> !n.isVisited())
        .forEach(DepthFirstSearchPreorder::dfsRecursive);
  }

  public static void dfsRecursiveBinaryTree(TreeNode node) {
    if (node != null) {
      System.out.print(node.value + " ");
      dfsRecursiveBinaryTree(node.left);
      dfsRecursiveBinaryTree(node.right);
    }
  }

  public static void dfsRecursiveWithoutLambda(Node node) {
    System.out.print(node.getValue() + " ");

    for (Node eachNode : node.getAdjacentNodes()) {
      if (!eachNode.isVisited()) {
        dfsRecursiveWithoutLambda(eachNode);
      }
    }
  }

  public static void dfsNonRecursive(Node node) {
    Stack<Node> stack = new Stack<>();
    Node currentNode = node;
    stack.push(currentNode);

    while (!stack.isEmpty()) {
      currentNode = stack.pop();
      if (!currentNode.isVisited()) {
        for (int i = currentNode.getAdjacentNodes().size() - 1; i >= 0; i--) {
          stack.push(currentNode.getAdjacentNodes().get(i));
        }

        System.out.print(currentNode.getValue() + " ");
      }
    }
  }

}

