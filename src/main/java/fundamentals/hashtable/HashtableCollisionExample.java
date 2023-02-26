package fundamentals.hashtable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashtableCollisionExample {

  public static void main(String[] args) {
    var asciiSumHash1 = new AsciiSumHashFunction("ABC");
    var asciiSumHash2 = new AsciiSumHashFunction("CBA");

    Map<AsciiSumHashFunction, String> mapAscii = new Hashtable<>();
    mapAscii.put(asciiSumHash1, "first hash");
    mapAscii.put(asciiSumHash2, "second hash");

    System.out.println(mapAscii.keySet());
  }

}
