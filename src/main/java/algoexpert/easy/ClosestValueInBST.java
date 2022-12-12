package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class ClosestValueInBST {

    public static int findClosestValueInBst(BST tree, int target) {
        Deque<BST> deque = new LinkedList<>();
        deque.add(tree);

        var closestValueInBst = 0;
        var targetDifference = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            BST currentBST = deque.poll();

            if (Math.abs(Math.max(target, currentBST.value) - Math.min(target, currentBST.value)) <
                    Math.abs(targetDifference)) {
                closestValueInBst = currentBST.value;
                targetDifference = target - currentBST.value;
            }

            if (currentBST.left != null) {
                deque.add(currentBST.left);
            }

            if (currentBST.right != null) {
                deque.add(currentBST.right);
            }
        }

        return closestValueInBst;
    }

    public static int findClosestValueInBstRecursive(BST tree, int target) {
        return findClosestValueInBstRecursive(tree, target, tree.value);
    }

    // Best O (n log n) time | O (n log n) space
    // Worst O (n) time | O (n log n) space
    public static int findClosestValueInBstRecursive(BST tree, int target, int closestValue) {
        if (Math.abs(target - closestValue) > Math.abs(target - tree.value)) {
            closestValue = tree.value;
        }
        if (target < tree.value && tree.left != null) {
            return findClosestValueInBstRecursive(tree.left, target, closestValue);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBstRecursive(tree.right, target, closestValue);
        } else {
            return closestValue;
        }
    }

    public static int findClosestValueInBstIterative(BST tree, int target) {
        var currentNode = tree;
        int closestValue = Integer.MAX_VALUE;

        while (currentNode != null) {
            if (Math.abs(target - closestValue) > Math.abs(target - currentNode.value)) {
                closestValue = currentNode.value;
            }
            if (target < currentNode.value) {
                currentNode = currentNode.left;
            } else if (target > currentNode.value) {
                currentNode = currentNode.right;
            } else {
                break;
            }
        }

        return closestValue;
    }

    @Test
    public void main() {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);

        var expected = 13;
//        var actual = findClosestValueInBstRecursive(root, 12);
        var actual = findClosestValueInBstIterative(root, 12);
        System.out.println(actual);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}
