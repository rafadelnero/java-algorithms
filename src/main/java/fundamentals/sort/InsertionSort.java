package fundamentals.sort;

import java.util.Arrays;

public class InsertionSort {

  public static void main(String[] args) {
    int[] array = {1, 5, 2, 3, 12, 8};
    var sortedArray = InsertionSort.sort(array);
    System.out.println(Arrays.toString(sortedArray));
  }

  public static int[] sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      var j = i;
      while (j > 0 && array[j - 1] > array[j]) {
        swap(array, j);
        j--;
      }
    }

    return array;
  }

  private static void swap(int[] array, int j) {
    var temp = array[j];
    array[j] = array[j - 1];
    array[j - 1] = temp;
  }

}
