package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class RiverSizes {

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                countRiverSize(matrix, i, j).ifPresent(riverSizes::add);
            }
        }

        return riverSizes;
    }

    private static Optional<Integer> countRiverSize(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) {
            return Optional.empty();
        }

        var hasLandUp = i - 1 < 0 || matrix[i - 1][j] == 0;
        var hasLandDown = i + 1 > matrix[i].length || matrix[i + 1][j] == 0;
        var hasLandRight = j + 1 < matrix[i].length || matrix[i][j + 1] == 0;
        var hasLandLeft = j - 1 < 0 || matrix[i][j - 1] == 0;

//        if (hasLandUp && hasLandDown && hasLandRight || )

        return Optional.of(null);
    }

    @Test
    public void TestCase1() {
        int[][] input = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        };
        int[] expected = {1, 2, 2, 2, 5};
        List<Integer> output = riverSizes(input);
        System.out.println(output);
    }
}
