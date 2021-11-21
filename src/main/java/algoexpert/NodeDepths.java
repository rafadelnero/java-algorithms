package algoexpert;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class NodeDepths {

    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsHelper(root, 0, new ArrayList<>());
    }

    private static int nodeDepthsHelper(BinaryTree currentNode, int depthSum, List<Integer> sum) {
        if (currentNode.left != null) {
            sum.add(++depthSum);
            System.out.println("currentNodeValue:" + currentNode.left.value + " depthSum:" + depthSum);
            nodeDepthsHelper(currentNode.left, depthSum, sum);
        }

        if (currentNode.left == null) {
            depthSum++;
        }

        if (currentNode.right != null) {
            sum.add(depthSum);
            System.out.println("currentNodeValue:" + currentNode.right.value + " depthSum:" + depthSum);
            nodeDepthsHelper(currentNode.right, depthSum, sum);
        }

        return sum.stream().mapToInt(e -> e).sum();
    }

    public static int nodeDepthsRecursive(BinaryTree root) {
        return nodeDepthsRecursive(root, 0);
    }

    private static int nodeDepthsRecursive(BinaryTree currentNode, int depthSum) {
        if (currentNode == null) {
            return 0;
        }
        return depthSum + nodeDepthsRecursive(currentNode.left, depthSum + 1) +
                nodeDepthsRecursive(currentNode.right, depthSum + 1);
    }

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    @Test
    public void TestCase1() {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.left.left = new BinaryTree(18);
        root.left.left.right = new BinaryTree(9);
        root.left.left.right.right = new BinaryTree(9);
        root.left.left.right.right.right = new BinaryTree(19);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nodeDepths(root);
        System.out.println(actual);
    }
}
