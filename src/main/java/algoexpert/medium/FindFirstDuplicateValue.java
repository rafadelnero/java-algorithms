package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class FindFirstDuplicateValue {

    // O(n) time | O(n) space
    public int firstDuplicateValue(int[] array) {
        Set<Integer> numberCounts = new HashSet<>();
        for (int eachNumber : array) {
            if (!numberCounts.add(eachNumber)) {
                return eachNumber;
            }
        }

        return -1;
    }

    // O(n) time | O(1) space - analyze and figure out
    public int firstDuplicateValueUserSolution(int[] array) {
        for (int value : array) {
            int absValue = Math.abs(value);
            if (array[absValue - 1] < 0)
                return absValue;

            array[absValue - 1] *= -1;
        }
        return -1;
    }

    @Test
    public void TestCase1() {
        var input = new int[] {2, 1, 5, 2, 3, 3, 4};
        var expected = 2;
        var actual = firstDuplicateValueUserSolution(input);
        System.out.println(actual);
    }
}
