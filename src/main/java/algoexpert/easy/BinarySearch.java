package algoexpert.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearch {

    // O (log(n)) time | O(1) space
    public static int binarySearch(int[] array, int target) {
        int middle = array.length / 2;

        var leftPointer = 0;
        var rightPointer = array.length - 1;

        while (leftPointer <= rightPointer) {
            if (array[middle] < target) {
                leftPointer = middle + 1;
            } else if (array[middle] > target) {
                rightPointer = middle - 1;
            } else {
                return middle;
            }

            middle = (leftPointer + rightPointer) / 2;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int target) {
        var leftPointer = 0;
        var rightPointer = array.length - 1;
        return binarySearchRecursive(array, target, leftPointer, rightPointer);
    }

    public static int binarySearchRecursive(int[] array, int target, int leftPointer, int rightPointer) {
        if (leftPointer > rightPointer) {
            return -1;
        }

        int middle = (leftPointer + rightPointer) / 2;
        int potentialMatch = array[middle];

        if (target == potentialMatch) {
            return middle;
        } else if (target < potentialMatch) {
            return binarySearchRecursive(array, target, leftPointer, middle - 1);
        } else {
            return binarySearchRecursive(array, target, middle + 1, rightPointer);
        }
    }

    @Test
    public void TestCase1() {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 61));
        System.out.println(binarySearchRecursive(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 61));
    }
}
