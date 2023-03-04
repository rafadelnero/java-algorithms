package fundamentals.hashtable;

import java.util.Objects;

public class AsciiSumHashFunction {
  String anyString;

  public AsciiSumHashFunction(String anyString) {
    this.anyString = anyString;
  }

  public static void main(String[] args) {
    var asciiSumHash1 = new AsciiSumHashFunction("ABC");
    var asciiSumHash2 = new AsciiSumHashFunction("CBA");
    System.out.println(asciiSumHash1.hashCode());
    System.out.println(asciiSumHash2.hashCode());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AsciiSumHashFunction that = (AsciiSumHashFunction) o;
    return Objects.equals(anyString, that.anyString);
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int i = 0; i < anyString.length(); i++) {
      hashCode += anyString.getBytes()[i];
    }
    return hashCode;
  }

  @Override
  public String toString() {
    return anyString;
  }
}
