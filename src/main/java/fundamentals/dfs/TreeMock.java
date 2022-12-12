package fundamentals.dfs;

public class TreeMock {

  public static TreeNode createTreeMock() {
    TreeNode rootTreeNode = new TreeNode(1);
    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode4 = new TreeNode(4);
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode6 = new TreeNode(6);
    TreeNode treeNode7 = new TreeNode(7);

    rootTreeNode.left = treeNode2;
    treeNode2.right = treeNode3;
    treeNode3.left = treeNode4;
    treeNode4.right = treeNode5;

    rootTreeNode.right = treeNode6;
    treeNode6.right = treeNode7;

    return rootTreeNode;
  }
}
