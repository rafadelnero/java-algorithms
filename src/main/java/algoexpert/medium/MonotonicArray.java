package algoexpert.medium;

import org.junit.jupiter.api.Test;

public class MonotonicArray {

    // O(n) time | O(1) space
    public static boolean isMonotonic(int[] array) {
        if (array.length == 0) {
            return true;
        }

        var nonDecreasing = false;
        var nonIncreasing = false;

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                nonDecreasing = true;
            } else if (array[i - 1] < array[i]) {
                nonIncreasing = true;
            }

            if (nonDecreasing && nonIncreasing) {
                return false;
            }
        }

        return true;
    }

    public static boolean isMonotonicUserSolution(int[] array) {
        var isNonDecreasing = true;
        var isNonIncreasing = true;

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                isNonDecreasing = false;
            }
            if (array[i] > array[i - 1]) {
                isNonIncreasing = false;
            }
        }

        return isNonDecreasing || isNonIncreasing;
    }

    @Test
    public void TestCase1() {
        var array = new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var expected = true;
        var actual = isMonotonic(array);
        System.out.println(actual);
    }
}
