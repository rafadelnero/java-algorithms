package fundamentals.big_o;

import org.junit.jupiter.api.Test;

public class OLogNExample {

  // O (log(n)) time | O(1) space
  public static int binarySearch(int[] array, int target) {
    int middle = array.length / 2;

    var leftPointer = 0;
    var rightPointer = array.length - 1;

    int iterationsCount = 0;

    while (leftPointer <= rightPointer) {
      iterationsCount++;
      if (array[middle] < target) {
        leftPointer = middle + 1;
      } else if (array[middle] > target) {
        rightPointer = middle - 1;
      } else {
        System.out.println("Iterations count: " + iterationsCount);
        return middle;
      }

      middle = (leftPointer + rightPointer) / 2;
    }
    return -1;
  }

  @Test
  public void testCaseLog4() {
    int [] array = {2, 3, 5, 7, 8, 10, 13, 16, 17, 18, 19, 22, 25, 26, 28, 30};
    System.out.println(binarySearch(array, 2));
    System.out.println(binarySearch(array, 17));
  }
}
