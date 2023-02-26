package fundamentals.big_o;

public class OnExample {

  public static void main(String[] args) {
    printNumbers(10);
  }

  public static void printNumbers(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(i);
    }
  }

  public static void printNumbers2Looping(int n) {
    for (int i = 0; i < n; i++) {
      System.out.println(i);
    }

    for (int j = 0; j < n; j++) {
      System.out.println(j);
    }
  }
}
