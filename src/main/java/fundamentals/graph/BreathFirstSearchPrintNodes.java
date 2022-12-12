package fundamentals.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class BreathFirstSearchPrintNodes {

    public static void printNodes(Node node) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);

        Node currentNode;
        Set<Node> alreadyVisited = new HashSet<>();
        System.out.print("Visited nodes: ");
        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.print(currentNode.getValue() + " | ");

            alreadyVisited.add(currentNode);
            queue.addAll(currentNode.getAdjacentNodes());
            queue.removeAll(alreadyVisited);
        }
    }

}
