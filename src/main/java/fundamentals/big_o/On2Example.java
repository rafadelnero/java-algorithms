package fundamentals.big_o;

public class On2Example {

  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int countOperations = countOperationsOn2(numbers);
    System.out.println(countOperations);
  }

  public static int countOperationsOn2(int[] numbers) {
    int countOperations = 0;
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        countOperations++;
      }
    }
    return countOperations;
  }

}
