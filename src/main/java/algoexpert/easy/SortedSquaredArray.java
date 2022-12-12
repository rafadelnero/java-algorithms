package algoexpert.easy;

import java.util.Arrays;

public class SortedSquaredArray {

    public static int[] sortedSquaredArray(int[] array) {
        // Big O(n log n) because of the sort method
        return Arrays.stream(array).map(number -> number * number).sorted().toArray();
    }

    // Big O(n)
    public static int[] sortedSquaredArrayPointerSolution(int[] array) {
        int[] sortedArray = new int[array.length];
        var minIndex = 0;
        var maxIndex = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            if (Math.abs(array[minIndex]) > Math.abs(array[maxIndex])) {
                sortedArray[i] = array[minIndex] * array[minIndex];
                minIndex++;
            } else {
                sortedArray[i] = array[maxIndex] * array[maxIndex];
                maxIndex--;
            }
        }
        return sortedArray;
    }


    public static void main(String[] args) {
//        int[] result = sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9});
//        int[] result = sortedSquaredArray(new int[]{-3, -2, -1});
//        int[] result = sortedSquaredArrayPointerSolution(new int[]{-3, -2, -1});
        int[] result = sortedSquaredArrayPointerSolution(new int[]{-2, -1});
        Arrays.stream(result).forEach(System.out::println);
    }

}
