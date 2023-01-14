package fundamentals.sort;

import java.util.Arrays;

public class SelectionSort {

  public static void main(String[] args) {
    int[] array = {5, 2, 3, 7, 1};
//    var sortedArray = sort(array);
    var sortedArray = sortMaxValue(array);
    System.out.println(Arrays.toString(sortedArray));
  }

  static int[] sort(int[] array) {
    if (array.length == 1) {
      return array;
    }

    var firstUnsortedIndex = 0;

    while (firstUnsortedIndex < array.length - 1) {
      var smallestElementIndex = firstUnsortedIndex;
      for (int i = firstUnsortedIndex; i < array.length; i++) {
        if (i != smallestElementIndex && array[i] < array[smallestElementIndex]) {
          smallestElementIndex = i;
        }
      }

      swapElements(array, firstUnsortedIndex, smallestElementIndex);
      firstUnsortedIndex++;
    }

    return array;
  }

  public static int[] sortMaxValue(int[] array) {
    var smallestElementIndex = 0;

    for (int i = 0; i < array.length; i++) {
      var smallestElement = Integer.MAX_VALUE;
      for (int j = i; j < array.length; j++) {
        if (array[j] < smallestElement) {
          smallestElement = array[j];
          smallestElementIndex = j;
        }
      }

      swapElements(array, i, smallestElementIndex);
      smallestElementIndex = 0;
    }
    return array;
  }

  private static void swapElements(int[] array, int i, int j) {
    var temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
