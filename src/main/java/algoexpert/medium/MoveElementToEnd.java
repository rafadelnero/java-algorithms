package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

    // O(n) time | O(1) space
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        var leftPointer = 0;
        var rightPointer = array.size() - 1;

        while (leftPointer < rightPointer) {
            if (array.get(rightPointer) == toMove) {
                rightPointer--;
            } else if (array.get(leftPointer) == toMove) {
                swap(array, leftPointer, rightPointer);
                rightPointer--;
                leftPointer++;
            } else {
                leftPointer++;
            }
        }

        return array;
    }

    private static void swap(List<Integer> array, int leftPointer, int rightPointer) {
        var temp = array.get(leftPointer);
        array.set(leftPointer, array.get(rightPointer));
        array.set(rightPointer, temp);
    }


    @Test
    public void TestCase1() {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));

        System.out.println(moveElementToEnd(array, toMove));
    }
}
