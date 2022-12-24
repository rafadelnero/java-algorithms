package fundamentals.dfs;

import fundamentals.graph.Node;
import fundamentals.mocks.GraphMock;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class DepthFirstSearchPostorder {

  public static void main(String[] args) {
    dfsRecursive(GraphMock.createDfsMock());
  }

  @Test
  public static void dfsRecursive(Node node) {
    for (Node eachNode : node.getAdjacentNodes()) {
      if (!eachNode.isVisited()) {
        dfsRecursive(eachNode);
      }
    }

    System.out.print(node.getValue() + " ");
  }

  @Test
  public static void dfsRecursiveWithLambda(Node node) {
    node.getAdjacentNodes().stream()
        .filter(n -> !n.isVisited())
        .forEach(DepthFirstSearchPostorder::dfsRecursiveWithLambda);

    System.out.print(node.getValue() + " ");
  }

  public static void dfsNonRecursive(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode current = stack.peek();
      var isLeaf = current.left == null && current.right == null;

      if (isLeaf) {
        TreeNode node = stack.pop();
        System.out.print(node.value + " ");
      } else {
        if (current.right != null) {
          stack.push(current.right);
          current.right = null;
        }
        if (current.left != null) {
          stack.push(current.left);
          current.left = null;
        }
      }
    }
  }

}

