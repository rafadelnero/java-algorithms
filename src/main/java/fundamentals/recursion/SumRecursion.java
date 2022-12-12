package fundamentals.recursion;

public class SumRecursion {

  public static void main(String[] args) {
    System.out.println(getNumber(0));
  }

  static int getNumber(int number) {
    if (number > 5) {
      return number;
    }

    return getNumber(number + 1);
  }

}
