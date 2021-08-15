/*
    Check the sum pairs
    { 2, 2, 3 } k = 4, returns (2, 2)
*/
class CodingProblem {

  // Test method
  public static void main(String[] args) {
    int[] array = new int[]{ 1, 1, 2 };
    List<PairNumber> list = getArrayPairsSum(array);
    System.out.println(list);

    int[] array = new int[]{8, 1, 0, 2, 11, 12, 5, 3, 9, 4} ;
    list = getArrayPairsSum(array);
    System.out.println(list);
  }

  // Method to compute all numbers that sum to target
  static List<PairNumber> getArrayPairsSum(int[] array, int targetValue) {
    List<PairNumber> list = new ArrayList<>();
    for(int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length; j++) {
        if (i == j)
          continue;

        if (array[i] + array[j] == targetValue) {
          list.add(new PairNumber(array[i], array[j]);
        }
      }
    }

    return list;
  }

  class PairNumber {

    private int num1;
    private int num2;

    PairNumber(int num1, int num2) {
      this.num1 = num1;
      this.num2 = num2;
    }

  }

}
