package com.algorithms;

public class IsUniqueCharacters {


  public static void main(String[] args) {
    System.out.println(isUniqueChars("testing!"));
  }

  static boolean isUniqueChars(String str) {
    if (str.length() > 128) return false;

    System.out.println(Integer.valueOf(10));

    boolean[] charSet = new boolean[128];
    for (var i = 0; i < str.length(); i++) {
      int val = str.charAt(i);
      if (charSet[val]) {
        return false;
      }
      charSet[val] = true;
    }

    return true;
  }


}
