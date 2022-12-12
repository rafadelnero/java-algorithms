package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ThreeNumberSort {

    // O(n) time | O(1) space
    public int[] threeNumberSort(int[] array, int[] order) {
        var orderedLeftIndex = sortByOrder(array, order[0], 0);
        orderedLeftIndex = sortByOrder(array, order[1], orderedLeftIndex);
        sortByOrder(array, order[2], orderedLeftIndex);
        return array;
    }

    private int sortByOrder(int[] array, int order, int orderedLeftIndex) {
        var left = orderedLeftIndex;
        var right = array.length - 1;

        while (left <= right) {
            if (array[left] == order) {
                left++;
                continue;
            } else if (array[right] == order) {
                var leftTemp = array[left];
                array[left] = array[right];
                array[right] = leftTemp;
                left++;
            }

            right--;
        }

        return left;
    }

    public int[] threeNumberSortSecondThirdNumberSolution(int[] array, int[] order) {
        int firstValue = order[0];
        int secondValue = order[1];

        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length - 1;

        while (secondIdx <= thirdIdx) {
            int value = array[secondIdx];

            if (value == firstValue) {
                swap(firstIdx, secondIdx, array);
                firstIdx += 1;
                secondIdx += 1;
            } else if (value == secondValue) {
                secondIdx += 1;
            } else {
                swap(secondIdx, thirdIdx, array);
                thirdIdx -= 1;
            }
        }

        return array;
    }

    public void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    @Test
    public void TestCase1() {
        var array = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        var order = new int[] {0, 1, -1};
        var expected = new int[] {0, 0, 0, 1, 1, 1, -1, -1};
        var actual = threeNumberSortSecondThirdNumberSolution(array, order);

        System.out.println(Arrays.toString(actual));
    }
}
