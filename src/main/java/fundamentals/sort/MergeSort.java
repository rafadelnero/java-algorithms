package fundamentals.sort;

public class MergeSort {

  public static void main(String[] args) {
    int [] numbers = new int[] {5, 3, 13, 8, 9, 10};
    mergeSort(numbers);
  }

  static int[] mergeSort(int[] array) {
    int[] sortedArray = new int[array.length];

    for (int i = 0; i < array.length / 2; i++) {
      if (sortedArray[i] > sortedArray[i + 1]) {
        swapArrayNumbers(array, i);
      }
    }

    return null;
  }

  private static void swapArrayNumbers(int[] array, int i) {
    int temp = array[i];
    array[i] = array[i + 1];
    array[i + 1] = temp;
  }

}
