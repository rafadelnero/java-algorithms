package fundamentals.tree;

public class CompanyHierarchyTree {

  public static void main(String[] args) {
    TreeNode rootTreeNode = new TreeNode("CEO");
    TreeNode vpNode = new TreeNode("Vice President");
    TreeNode managerNode = new TreeNode("Manager");
    TreeNode dev1Node = new TreeNode("Developer 1");
    TreeNode dev2Node = new TreeNode("Developer 2");
    TreeNode dev3Node = new TreeNode("Developer 3");
    rootTreeNode.addChild(vpNode);
    vpNode.addChild(managerNode);
    managerNode.addChild(dev1Node);
    managerNode.addChild(dev2Node);
    managerNode.addChild(dev3Node);

    rootTreeNode.showTreeNodes();
  }

}
