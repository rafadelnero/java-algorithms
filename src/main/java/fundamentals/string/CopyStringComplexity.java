package fundamentals.string;

public class CopyStringComplexity {
  public static void main(String[] args) {

  }

  static void concatenateStringOnComplexity() {
    String duke = "Awesome Duke ";
    String juggy = "Awesome Juggy";

    String dukeAndJuggy;

    // O(n) time complexity
    dukeAndJuggy = duke + juggy;
    System.out.println(dukeAndJuggy);
  }

  static void concatenateStringOn2Complexity(int n) {
    String duke = "Awesome Duke ";
    String juggy = "Awesome Juggy";

    String dukeAndJuggy = "";

    // O(n^2) time complexity
    for (int i = 0; i < n; i++) {
      dukeAndJuggy = duke + juggy;
    }
    System.out.println(dukeAndJuggy);
  }
}
