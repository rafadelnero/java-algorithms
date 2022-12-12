package fundamentals.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {

  private String value;
  private List<TreeNode> childNodes;

  public TreeNode(String value) {
    this.value = value;
    this.childNodes = new LinkedList<>();
  }

  public void addChild(TreeNode childNode) {
    this.childNodes.add(childNode);
  }

  public void showTreeNodes() {
    BreathFirstSearchPrintTreeNodes.printNodes(this);
  }

  public String getValue() {
    return value;
  }

  public List<TreeNode> getChildNodes() {
    return childNodes;
  }
}
