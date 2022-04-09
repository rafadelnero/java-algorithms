package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        if (array.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        var startRow = 0;
        var endRow = array.length - 1;
        var startCol = 0;
        var endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (int col = startCol; col <= endCol; col++) {
                result.add(array[startRow][col]);
            }

            for (int row = startRow + 1; row <= endRow; row++) {
                result.add(array[row][endCol]);
            }

            for (int col = endCol - 1; col >= startCol; col--) {
                if (startRow == endRow) break;
                result.add(array[endRow][col]);
            }

            for (int row = endRow - 1; row > startRow; row--) {
                if (startCol == endCol) break;
                result.add(array[row][startCol]);
            }

            startRow++;
            endRow--;
            startCol++;
            endCol--;
        }

        return result;
    }

    public static List<Integer> spiralTraverseRecursive(int[][] array) {
        if (array.length == 0) return new ArrayList<>();

        var result = new ArrayList<Integer>();
        spiralFill(array, 0, array.length - 1, 0, array[0].length - 1, result);
        return result;
    }

    public static void spiralFill(int [][] array, int startRow, int endRow,
                                  int startCol, int endCol, List<Integer> result) {
        if (startRow > endRow || startCol > endCol) {
            return;
        }

        for (int col = startCol; col <= endCol; col++) {
            result.add(array[startRow][col]);
        }

        for (int row = startRow + 1; row <= endRow; row++) {
            result.add(array[row][endCol]);
        }

        for (int col = endCol - 1; col >= startCol; col--) {
            if (startRow == endRow) break;
            result.add(array[endRow][col]);
        }

        for (int row = endRow - 1; row > startRow; row--) {
            if (startCol == endCol) break;
            result.add(array[row][startCol]);
        }

        spiralFill(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1, result);
    }

    @Test
    public void TestCase1() {
        var input =
                new int[][] {
                        {1, 2, 3, 4},
                        {12, 13, 14, 5},
                        {11, 16, 15, 6},
                        {10, 9, 8, 7},
                };
        var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var actual = spiralTraverseRecursive(input);
        System.out.println(actual);
    }

    @Test
    public void TestCase2() {
        var input =
                new int[][] {
                        {1},
                };
        var expected = Arrays.asList(1);
        var actual = spiralTraverse(input);
        System.out.println(actual);
    }

}
