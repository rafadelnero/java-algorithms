package fundamentals.string;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class ConcatenationComparison {

  public static void main(String[] args) {
    var nSize = 100000;
    concatenateString(nSize);
    concatenateStringBuilder(nSize);
    concatenateStringBuffer(nSize);
  }

  static void concatenateString(int n) {
    var timeMillis = System.currentTimeMillis();
    String concatString = "";

    // O(n2) time complexity
    for (int i = 0; i < n; i++) {
      concatString += i;
    }

    var processTime = System.currentTimeMillis() - timeMillis;
    System.out.println(processTime + " milliseconds");
  }


  static void concatenateStringBuilder(int n) {
    var timeMillis = System.currentTimeMillis();
    StringBuilder concatStringBuilder = new StringBuilder();

    // O(n) time complexity
    for (int i = 0; i < n; i++) {
      concatStringBuilder.append(i);
    }

    var processTime = System.currentTimeMillis() - timeMillis;
    System.out.println(processTime + " milliseconds");
  }

  static void concatenateStringBuffer(int n) {
    var timeMillis = System.currentTimeMillis();
    StringBuffer concatStringBuffer = new StringBuffer();

    // O(n) time complexity
    for (int i = 0; i < n; i++) {
      concatStringBuffer.append(i);
    }

    var processTime = System.currentTimeMillis() - timeMillis;
    System.out.println(processTime + " milliseconds");
  }
}
