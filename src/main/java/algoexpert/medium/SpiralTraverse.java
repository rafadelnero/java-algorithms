package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> spiralTraverse = new ArrayList<>();

        var startingRow = 0;
        var startingColumn = 0;
        var endingColumn = 0;
        var endingRow = 0;

        var spiralSize = array.length - 1;

        for (; startingColumn < spiralSize; startingColumn++) {
            spiralTraverse.add(array[startingRow][startingColumn]);
        }

        for (int i = startingColumn; i < spiralSize; i++) {
            spiralTraverse.add(array[++startingRow][startingColumn]);
        }

        for (int i = startingColumn; i < spiralSize; i++) {
            spiralTraverse.add(array[startingRow][startingColumn--]);
        }


        return spiralTraverse;
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
        var actual = spiralTraverse(input);
        System.out.println(actual);
    }

}
