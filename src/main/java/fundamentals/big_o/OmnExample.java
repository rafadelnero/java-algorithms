package fundamentals.big_o;

public class OmnExample {

  public static void main(String[] args) {
    printNumbers(10, 5);
  }

  // O(m+n)
  public static void printNumbers(int m, int n) {
    for (int i = 0; i < m; i++) {
      System.out.println(i);
    }

    for (int i = 0; i < n; i++) {
      System.out.println(i);
    }
  }
}
