package fundamentals.tree;

import fundamentals.graph.Node;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreathFirstSearchPrintTreeNodes {

    public static void printNodes(TreeNode node) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);

        TreeNode currentNode;
        Set<TreeNode> alreadyVisited = new HashSet<>();
        System.out.print("Visited nodes: ");
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.print(currentNode.getValue() + " | ");

            alreadyVisited.add(currentNode);
            queue.addAll(currentNode.getChildNodes());
            queue.removeAll(alreadyVisited);
        }
    }

}
