package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int[] array = {2, 9, 5, 5, 6, 8, 10};
    int[] totallyUnsortedArray = {10, 8, 6, 5, 5, 2, 1};
    int[] alreadySortedArray = {1, 2, 3, 4, 5, 6, 7};

    int[] result = sort(totallyUnsortedArray);
//    int[] result = sortOptimized(alreadySortedArray);
    Arrays.stream(result).forEach(e -> System.out.print(e + " "));
  }

  public static int[] sort(int[] array) {
    int iterations = 0;
    for (int i = 0; i < array.length; i++) {
      iterations++;
      for (int j = i + 1; j < array.length; j++) {
        iterations++;
        if (array[i] > array[j]) {
          swapElements(array, i, j);
        }
      }
    }

    System.out.println("Iterations: " + iterations);

    return array;
  }

  public static int[] sortOptimized(int[] array) {
    int iterations = 0;
    var isSorted = false;
    var counter = 0;

    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length - 1 - counter; i++) {
        iterations++;
        if (array[i] > array[i + 1]) {
          swapElements(array, i, i + 1);
          isSorted = false;
        }
      }

      counter++;
    }
    System.out.println("Iterations: " + iterations);
    return array;
  }

  private static void swapElements(int[] array, int i, int j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  @Test
  public void TestCase1() {
    int[] expected = {2, 3, 5, 5, 6, 8, 9};
    int[] input = {8, 5, 2, 9, 5, 6, 3};

    int[] result = sortOptimized(input);
    Arrays.stream(result).forEach(System.out::println);
    System.out.println(Arrays.equals(result, expected));
  }
}
