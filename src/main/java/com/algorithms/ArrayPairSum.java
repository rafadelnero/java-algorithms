package com.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Check the sum pairs
    { 2, 2, 3 } k = 4, returns (2, 2)
*/
class CodingProblem {

  // Test method
  public static void main(String[] args) {
    int[] array = new int[]{ 1, 1, 2 };
    List<PairNumber> list = getArrayPairsSum(array, 3);
    System.out.println(list);

    list = getArrayPairsSumSort(array, 3);
    System.out.println(list);
  }

  // Method to compute all numbers that sum to target
  static List<PairNumber> getArrayPairsSum(int[] array, int targetValue) {
    List<PairNumber> list = new ArrayList<>();
    for(int i = 0; i < array.length; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[i] + array[j] == targetValue) {
          list.add(new PairNumber(array[i], array[j]));
        }
      }
    }

    return list;
  }

  static List<PairNumber> getArrayPairsSumSort(int[] array, int targetValue) {
    List<PairNumber> list = new ArrayList<>();
    Arrays.sort(array);
    for(int i = 0; i < array.length - 1; i++) {
        if (array[i] + array[i + 1] == targetValue) {
          list.add(new PairNumber(array[i], array[i + 1]));
      }
    }
    return list;
  }

  static class PairNumber {

    private int num1;
    private int num2;

    PairNumber(int num1, int num2) {
      this.num1 = num1;
      this.num2 = num2;
    }

    @Override
    public String toString() {
      return "PairNumber{" +
          "num1=" + num1 +
          ", num2=" + num2 +
          '}';
    }
  }

}
