package algoexpert;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {

    public static List<Integer> branchSums(BinaryTree root) {
        return branchSumsHelper(root, 0, new ArrayList<>());
    }

    private static List<Integer> branchSumsHelper(BinaryTree currentNode, int sum, List<Integer> branchSums) {
        sum += currentNode.value;

        if (currentNode.left != null) {
            branchSumsHelper(currentNode.left, sum, branchSums);
        }

        if (currentNode.right != null) {
            branchSumsHelper(currentNode.right, sum, branchSums);
        }

        if (currentNode.left == null && currentNode.right == null) {
            branchSums.add(sum);
        }

        return branchSums;
    }

    public static List<Integer> branchSumsUser(BinaryTree root) {
        List<Integer> list = new ArrayList<>();
        branchSumsHelperUser(root, 0, list);
        return list;
    }

    private static void branchSumsHelperUser(BinaryTree currentNode, int runningSum, List<Integer> branchSums) {
        if (currentNode == null) return;

        int newRunningSum = runningSum + currentNode.value;

        if (currentNode.left == null && currentNode.right == null) {
            branchSums.add(newRunningSum);
            return;
        }

        branchSumsHelper(currentNode.left, newRunningSum, branchSums);
        branchSumsHelper(currentNode.right, newRunningSum, branchSums);
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
    public void main() {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.right = new BinaryTree(5);
        root.left.right.left = new BinaryTree(10);
        root.left.left.right = new BinaryTree(9);

        root.right = new BinaryTree(3);
        root.right.right = new BinaryTree(7);
        root.right.left = new BinaryTree(6);

        var actual = branchSumsUser(root);
        System.out.println(actual);
    }
}
