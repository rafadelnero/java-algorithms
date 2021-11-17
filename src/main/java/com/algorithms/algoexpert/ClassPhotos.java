package com.algorithms.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {

  public static boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Find out what is the array that will be behind
    // Check what is the highest number in the arrays to find this out
    // Check what is the closest number from the other array on each person of the queue
    // When find the closest person, delete these elements from both arrays
    boolean isRedBehind = Collections.max(redShirtHeights) > Collections.max(blueShirtHeights);
    Collections.sort(redShirtHeights);
    Collections.sort(blueShirtHeights);

    if (isRedBehind) {
      for (int i = 0; i < redShirtHeights.size(); i++) {
        if (redShirtHeights.get(i) < blueShirtHeights.get(i)) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
    ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
    boolean expected = true;
    boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
    System.out.println(actual);
  }

}
