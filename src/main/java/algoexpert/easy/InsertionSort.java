package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertionSort {

    // O(n2) time | O(1) space
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var j = i;
            while (j > 0 && array[j - 1] > array[j]) {
                var temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }

        return array;
    }

    @Test
    public void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};

        System.out.println(Arrays.toString(insertionSort(input)));
    }
}
