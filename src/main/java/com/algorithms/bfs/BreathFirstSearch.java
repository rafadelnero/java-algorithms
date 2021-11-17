package com.algorithms.bfs;

import java.util.*;

public class BreathFirstSearch {

    // Breath-First Search uses a Queue
    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        Tree<T> currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.remove();

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return Optional.empty();
    }

    public static <T> Optional<Node<T>> search(T value, Node<T> start) {
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> alreadyVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            System.out.printf("Visited node with value: %s \n", currentNode.getValue());

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            } else {
                alreadyVisited.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }

        return Optional.empty();
    }

    public static void main(String[] args) {
        Node<String> nodeA = new Node<>("A");
        Node<String> nodeB = new Node<>("B");
        Node<String> nodeC = new Node<>("C");
        Node<String> nodeD = new Node<>("D");
        Node<String> nodeE = new Node<>("E");
        nodeA.connect(nodeB);
        nodeA.connect(nodeC);
        nodeB.connect(nodeD);
        nodeB.connect(nodeE);
        System.out.println(nodeA);

        search("E", nodeA);
    }

}
