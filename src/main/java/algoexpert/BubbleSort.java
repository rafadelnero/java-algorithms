package algoexpert;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    var temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }
            }
        }

        return array;
    }

    public static int[] bubbleSortOptimized(int[] array) {
        var isSorted = false;
        var counter = 0;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1 - counter; i++) {
                if (array[i] > array[i + 1]) {
                    var temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }

            counter++;
        }

        return array;
    }

    @Test
    public void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};

        int[] result = bubbleSortOptimized(input);
        Arrays.stream(result).forEach(System.out::println);
        System.out.println(Arrays.equals(result, expected));
    }
}
