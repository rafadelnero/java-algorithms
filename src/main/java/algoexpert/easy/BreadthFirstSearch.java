package algoexpert.easy;

import java.util.*;

public class BreadthFirstSearch {

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> nodes = new ArrayDeque<>();

            nodes.add(this);

            while (!nodes.isEmpty()) {
                Node node = nodes.poll();
                array.add(node.name);
                nodes.addAll(node.children);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        public static void main(String[] args) {
            Node nodeA = new Node("A");
            Node nodeB = new Node("B");
            Node nodeC = new Node("C");
            Node nodeD = new Node("D");

            nodeA.children.add(nodeB);
            nodeA.children.add(nodeC);
            nodeA.children.add(nodeD);

            Node nodeE = new Node("E");
            Node nodeF = new Node("F");
            Node nodeG = new Node("G");
            Node nodeH = new Node("H");

            nodeB.children.add(nodeE);
            nodeB.children.add(nodeF);
            nodeD.children.add(nodeG);
            nodeD.children.add(nodeH);

            nodeG.addChild("K");
            nodeF.addChild("I");
            nodeF.addChild("G");

            List<String> output = new ArrayList<>();
            nodeA.breadthFirstSearch(output);
            System.out.println(output);
        }
    }
}
