package fundamentals.dfs;

import fundamentals.mocks.TreeMock;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class DepthFirstSearchInorder {

  public static void main(String[] args) {
    dfsRecursive(TreeMock.createTreeMock());
  }

  @Test
  public static void dfsRecursive(TreeNode node) {
    if (node != null) {
      dfsRecursive(node.left);
      System.out.print(node.value + " ");
      dfsRecursive(node.right);
    }
  }

  public static void dfsNonRecursive(TreeNode node) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = node;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      TreeNode lastNode = stack.pop();
      System.out.print(lastNode.value + " ");
      current = lastNode.right;
    }
  }
}

