package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FindThreeLargestNumbers {

    // Brute force solution
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] biggestNumbers = new int[3];

        biggestNumbers[0] = findBiggestNumber(array);
        deleteBiggestNumberInArray(array, biggestNumbers[0]);

        biggestNumbers[1] = findBiggestNumber(array);
        deleteBiggestNumberInArray(array, biggestNumbers[1]);

        biggestNumbers[2] = findBiggestNumber(array);
        Arrays.sort(biggestNumbers);
        return biggestNumbers;
    }

    private static int findBiggestNumber(int[] array) {
        int biggestNumber = Integer.MIN_VALUE;
        for (int eachNumber : array) {
            if (eachNumber > biggestNumber) {
                biggestNumber = eachNumber;
            }
        }

        return biggestNumber;
    }

    private static void deleteBiggestNumberInArray(int[] array, int biggestNumber) {
        for (int i = 0; i < array.length; i++) {
            if (biggestNumber == array[i]) {
                array[i] = Integer.MIN_VALUE;
                break;
            }
        }
    }

    public static int[] findThreeLargestNumbersOptimized(int[] array) {
        int[] biggestNumbers = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (var num : array) {
           populateThreeLargestNumbers(num, biggestNumbers);
        }

        return biggestNumbers;
    }

    private static void populateThreeLargestNumbers(int num, int[] biggestNumbers) {
        if (num > biggestNumbers[2]) {
            shiftAndUpdate(biggestNumbers, num, 2);
        } else if (num > biggestNumbers[1]) {
            shiftAndUpdate(biggestNumbers, num, 1);
        } else if (num > biggestNumbers[0]) {
            shiftAndUpdate(biggestNumbers, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] array, int num, int biggestNumberIndex) {
        for (int i = 0; i <= biggestNumberIndex; i++) {
            if (i == biggestNumberIndex) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }

    @Test
    public void TestCase1() {
        int[] expected = {18, 141, 541};
//        int[] result = findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
//        int[] result = findThreeLargestNumbers(new int[] {7, 7, 7, 7, 7, 7, 8, 7, 7, 7, 7});
//        int[] result = findThreeLargestNumbers(new int[] {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7});
        int[] result = findThreeLargestNumbersOptimized(new int[] {-1, -2, -3, -7, -17, -27, -18, -541, -8, -7, 7});

        System.out.println(Arrays.toString(result));
    }
}
