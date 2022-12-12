package fundamentals.dfs;

import fundamentals.graph.Node;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class DepthFirstSearchPostorder {

  public static void main(String[] args) {
    Node rootNode = GraphMock.createGraphMock();
//    dfsRecursive(rootNode);

    dfsNonRecursive(TreeMock.createTreeMock());
  }

  @Test
  public static void dfsRecursiveWithoutLambda(Node node) {
    for (Node eachNode : node.getAdjacentNodes()) {
      if (!eachNode.isVisited()) {
        dfsRecursiveWithoutLambda(eachNode);
      }
    }

    System.out.print(node.getValue() + " ");
  }

  @Test
  public static void dfsRecursive(Node node) {
    node.getAdjacentNodes().stream()
        .filter(n -> !n.isVisited())
        .forEach(DepthFirstSearchPostorder::dfsRecursive);

    System.out.print(node.getValue() + " ");
  }

  public static void dfsNonRecursive(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode prev = root;
    TreeNode current;
    stack.push(root);

    while (!stack.isEmpty()) {
      current = stack.peek();
      boolean hasChild = current.left != null || current.right != null;
      boolean isPrevLastChild = (prev == current.right ||
          (prev == current.left && current.right == null));

      if (!hasChild || isPrevLastChild) {
        current = stack.pop();
        System.out.print(current.value + " ");
        prev = current;
      } else {
        if (current.right != null) {
          stack.push(current.right);
        }
        if (current.left != null) {
          stack.push(current.left);
        }
      }
    }
  }

}

