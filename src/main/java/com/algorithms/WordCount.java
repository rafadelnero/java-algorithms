package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

public class WordCount {

  public static void main(String[] args) {
    wordCount("A happy man is a good man");
  }

  //Given a {string} text print how many times(count) words appears
  //A happy man is a good man
  //A - 2, happy -1 - man - 2, is - 1, good -1
  private static void wordCount(String text) {
    String[] words = text.split(" ");

    Map<String, Integer> wordCountMap = new HashMap<>();
    for (String word : words) {
      wordCountMap.put(word.toLowerCase(), wordCountMap.getOrDefault(word, 0) + 1);
    }

    var sorted = new ArrayList<>(wordCountMap.values());
    Collections.sort(sorted);
    System.out.println(sorted);
//    for (String w : sorted) {
//      System.out.println(w + " - " + wordCountMap.get(w));
//    }

//    Map<Integer, String> sortedWordsCountMap = new HashMap<>();
//    for (String word: wordCountMap.keySet()) {
//      if (wordCountMap.get(word).compareTo()) {
//    }

//    System.out.println(wordCountMap);
//
    wordCountMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .forEach(System.out::println);
  }
}
