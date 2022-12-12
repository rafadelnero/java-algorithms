package fundamentals.recursion;

public class NumbersRecursion {

  public static void main(String[] args) {
    showNumbers(0);
  }

  static void showNumbers(int number) {
    if (number == 5) {
      return;
    }
    showNumbers(number + 1);
    System.out.print(number + " ");
  }
}
