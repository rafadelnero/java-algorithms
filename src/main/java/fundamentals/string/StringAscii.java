package fundamentals.string;

public class StringAscii {

  public static void main(String[] args) {
    String challenger = "ABCDabcd1234";

    // O(n) time complexity
    for (int i = 0; i < challenger.length(); i++) {
      char character = challenger.toCharArray()[i];
      byte characterAsciiNumber = challenger.getBytes()[i];
      System.out.print(character + ":" + characterAsciiNumber + " ");
    }
  }

}
