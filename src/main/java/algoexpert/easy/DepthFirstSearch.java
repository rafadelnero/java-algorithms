package algoexpert.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearchWithoutRecursion(List<String> array) {
            Stack<Node> stack = new Stack<>();
            stack.add(this);

            while (!stack.isEmpty()) {
                Node currentNode = stack.pop();
                array.add(currentNode.name);
                stack.addAll(currentNode.children);
            }
            return array;
        }

        public List<String> depthFirstSearchWithRecursion(List<String> array) {
            array.add(this.name);

            for (Node eachNode : this.children)
                eachNode.depthFirstSearchWithRecursion(array);

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
            nodeA.depthFirstSearchWithRecursion(output);
            System.out.println(output);
        }
    }
}
