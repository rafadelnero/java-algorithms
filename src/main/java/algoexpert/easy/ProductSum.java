package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static int productSum(List<Object> array) {
        var productSum = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) instanceof Integer) {
                productSum += (Integer) array.get(i);
            }

            if (array.get(i) instanceof ArrayList) {
                ArrayList<?> secondArray = (ArrayList<?>) array.get(i);
                for (int j = 0; j < secondArray.size(); j++) {
                    if (secondArray.get(j) instanceof Integer) {
                        productSum += 2 * (Integer) secondArray.get(j);
                    }

                    if (secondArray.get(j) instanceof ArrayList) {
                        ArrayList<?> innerMostArray = (ArrayList<?>) secondArray.get(j);
                        for (int k = 0; k < innerMostArray.size(); k++) {
                            productSum += 3 * (Integer) innerMostArray.get(k);
                        }
                    }

                }
            }

        }
        return productSum;
    }

    public static int productSumRecursive(List<Object> array) {
       return productSumRecursiveHelper(array, 1);
    }

    // O(n) it counts the array levels also | O(d) for each array dimension
    public static int productSumRecursiveHelper(List<Object> array, int multiplierIncrementer) {
        var sum = 0;
        for (Object number : array) {
            if (number instanceof ArrayList) {
                sum += productSumRecursiveHelper((List) number, multiplierIncrementer + 1);
            } else {
                sum += (Integer) number;
            }
        }
        return sum * multiplierIncrementer;
    }

    @Test
    public void TestCase1() {
        List<Object> test =
                new ArrayList<>(
                        Arrays.asList(
                                5,  // 5
                                2,  // 7
                                new ArrayList<Object>(Arrays.asList(7, -1)), // -14
                                3, // -11
                                new ArrayList<Object>(
                                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));

        System.out.println(productSumRecursive(test));
    }


}
