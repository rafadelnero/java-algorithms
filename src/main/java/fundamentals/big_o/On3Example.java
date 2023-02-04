package fundamentals.big_o;

public class On3Example {

  public static void main(String[] args) {
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int countOperations = countOperationsOn3(numbers);
    System.out.println(countOperations);
  }

  public static int countOperationsOn3(int[] numbers) {
    int countOperations = 0;
    for (int i = 0; i < numbers.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        for (int k = 0; k < numbers.length; k++) {
          countOperations++;
        }
      }
    }
    return countOperations;
  }

}
