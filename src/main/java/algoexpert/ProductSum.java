package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProductSum {

  public static int productSum(List<Object> array) {
    var productSum = 0;
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) instanceof Integer) {
        productSum += (Integer) array.get(i);
      }

      if (array.get(i) instanceof ArrayList) {
        ArrayList<?> secondArray = (ArrayList<?>) array.get(i);

        var secondArraySum = 0;
        for (int j = 0; j < secondArray.size(); j++) {
          if (secondArray.get(j) instanceof Integer && j != secondArray.size() - 1) {
            secondArraySum += (Integer) secondArray.get(j);
          } else if (j == secondArray.size() - 1) {
            productSum += 2 * ((Integer) secondArray.get(j) + secondArraySum);
            secondArraySum = 0;
          }

          if (secondArray.get(j) instanceof ArrayList) {
            var innerMostArraySum = 0;
            ArrayList<?> innerMostArray = (ArrayList<?>) secondArray.get(j);
            for (int k = 0; k < innerMostArray.size(); k++) {
              if (k != innerMostArray.size() - 1) {
                innerMostArraySum += (Integer) innerMostArray.get(k);
              } else if (k == innerMostArray.size() - 1) {
                productSum += 3 * (innerMostArraySum + (Integer) innerMostArray.get(k));
                innerMostArraySum = 0;
              }
            }

          }

        }
      }

    }
    return productSum;
  }

  @Test
  public void TestCase1() {
    List<Object> test =
        new ArrayList<>(
            Arrays.asList(
                5,
                2,
                new ArrayList<Object>(Arrays.asList(7, -1)),
                3,
                new ArrayList<Object>(
                    Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
//    assertEquals(12, productSum(test));

    System.out.println(productSum(test));
  }

}
