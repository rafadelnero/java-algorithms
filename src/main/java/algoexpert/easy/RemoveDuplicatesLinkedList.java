package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.*;

public class RemoveDuplicatesLinkedList {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        public LinkedList addMany(LinkedList ll, List<Integer> values) {
            LinkedList current = ll;
            while (current.next != null) {
                current = current.next;
            }
            for (int value : values) {
                current.next = new LinkedList(value);
                current = current.next;
            }
            return ll;
        }

        public List<Integer> getNodesInArray(LinkedList ll) {
            List<Integer> nodes = new ArrayList<>();
            LinkedList current = ll;
            while (current != null) {
                nodes.add(current.value);
                current = current.next;
            }
            return nodes;
        }
    }

    // O(n) time | O(1) space
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        var currentNode = linkedList;

        while (currentNode != null) {
            var nextDifferentNode = currentNode.next;
            while (nextDifferentNode!= null &&currentNode.value == nextDifferentNode.value) {
                nextDifferentNode = nextDifferentNode.next;
            }
            currentNode.next = nextDifferentNode;
            currentNode = nextDifferentNode;
        }

        return linkedList;
    }

    @Test
    public void TestCase1() {
        LinkedList input = new LinkedList(1);
        input.addMany(input, new ArrayList<>(Arrays.asList(1, 3, 4, 4, 4, 5, 6, 6)));
        List<Integer> expectedNodes = new ArrayList<>(Arrays.asList(1, 3, 4, 5, 6));
        LinkedList output = removeDuplicatesFromLinkedList(input);
        System.out.println(input.getNodesInArray(output));
    }
}
