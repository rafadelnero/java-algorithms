package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SelectionSort {

    // O (O(n2)) | O(1) space
    public static int[] selectionSort(int[] array) {
        var smallestNumberIndex = 0;

        for (int i = 0; i < array.length; i++) {
            var smallestNumber = Integer.MAX_VALUE;
            for (int j = i; j < array.length; j++) {
                if (array[j] < smallestNumber) {
                    smallestNumber = array[j];
                    smallestNumberIndex = j;
                }
            }

            var temp = array[i];
            array[i] = array[smallestNumberIndex];
            array[smallestNumberIndex] = temp;
            smallestNumberIndex = 0;
        }
        return array;
    }

    // O (O(n2)) | O(1) space
    public static int[] selectionSortUserSolution(int[] array) {
        var currentIndex = 0;

        while (currentIndex < array.length - 1) {
            var smallestIndex = currentIndex;

            for (int i = currentIndex; i < array.length; i++) {
                if (array[smallestIndex] > array[i]) {
                    smallestIndex = i;
                }
            }
            swap(currentIndex, smallestIndex, array);
            currentIndex++;
        }
        return array;
    }

    static void swap(int i, int j, int[] array) {
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void TestCase1() {
//        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(selectionSortUserSolution(input)));
    }
}
