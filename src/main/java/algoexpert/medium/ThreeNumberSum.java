package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    // O(n^3) time | O(N) space
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == targetSum) {
                        result.add(new Integer[] {array[i], array[j], array[k]});
                    }
                }
            }
        }
        return result;
    }

    // O(n^2) time | O(N) space
    public static List<Integer[]> threeNumberSumPointerSolution(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            var leftPointer = i + 1;
            var rightPointer = array.length - 1;
            while (leftPointer < rightPointer) {
                if (array[i] + array[leftPointer] + array[rightPointer] < targetSum) {
                    leftPointer++;
                } else if (array[i] + array[leftPointer] + array[rightPointer] > targetSum) {
                    rightPointer--;
                } else {
                    result.add(new Integer[]{array[i], array[leftPointer], array[rightPointer]});
                    leftPointer++;
                    rightPointer--;
                }
            }
        }

        return result;
    }

    @Test
    public void TestCase1() {
        List<Integer[]> expected = new ArrayList<>();
        expected.add(new Integer[] {-8, 2, 6});
        expected.add(new Integer[] {-8, 3, 5});
        expected.add(new Integer[] {-6, 1, 5});
//        List<Integer[]> output = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        List<Integer[]> output = threeNumberSumPointerSolution(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        System.out.println(output);
    }
}
