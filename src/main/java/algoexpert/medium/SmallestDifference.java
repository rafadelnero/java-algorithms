package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SmallestDifference {

    // O(n^2) time | O(1) space
    public static int[] smallestDifferenceBruteForce(int[] arrayOne, int[] arrayTwo) {
        int[] smallestDifference = new int[2];
        var smallestNumber = Integer.MAX_VALUE;

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (Math.max(arrayOne[i], arrayTwo[j]) - Math.min(arrayOne[i], arrayTwo[j]) < smallestNumber) {
                    smallestNumber = Math.max(arrayOne[i], arrayTwo[j]) - Math.min(arrayOne[i], arrayTwo[j]);
                    smallestDifference[0] = arrayOne[i];
                    smallestDifference[1] = arrayTwo[j];
                }
            }
        }

        return smallestDifference;
    }

    // O (n log n) + O (m log m) time | O(1) space
    public static int[] smallestDifferenceOptimalSolution(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] smallestDifference = new int[2];
        var smallestNumber = Integer.MAX_VALUE;

        var i = 0;
        var j = 0;

        while (i < arrayOne.length && j < arrayTwo.length) {
            var numberDifference = Math.abs(arrayOne[i] - arrayTwo[j]);

            if (numberDifference == 0) {
                smallestDifference[0] = arrayOne[i];
                smallestDifference[1] = arrayTwo[j];
                break;
            } else if (numberDifference < smallestNumber) {
                smallestNumber = numberDifference;
                smallestDifference[0] = arrayOne[i];
                smallestDifference[1] = arrayTwo[j];
            }

            if (arrayOne[i] < arrayTwo[j]) {
                i++;
            } else if (arrayTwo[j] < arrayOne[i]) {
                j++;
            } else {
                break;
            }
        }

        return smallestDifference;
    }

    @Test
    public void TestCase1() {
        System.out.println(Arrays.toString(smallestDifferenceOptimalSolution(new int[]{-1, 5, 10, 20, 28, 3},
                new int[]{26, 134, 135, 15, 17})));
    }
}
