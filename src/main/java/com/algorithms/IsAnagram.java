package com.algorithms;

public class IsAnagram {

  public static void main(String[] args) {
    System.out.println(isAnagram("anagram", "nagaram"));
    System.out.println(isAnagram("anagrams", "nasgaram"));
  }

  static boolean isAnagram(String str1, String str2) {
    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();

    int charSum1 = countChars(charArray1);
    int charSum2 = countChars(charArray2);

    return charSum1 == charSum2;
  }

  private static int countChars(char[] charArray) {
    var charSum = 0;
    for (char letter : charArray) {
      charSum += letter;
    }
    return charSum;
  }

}
