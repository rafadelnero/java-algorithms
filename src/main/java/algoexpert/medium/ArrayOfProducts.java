package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayOfProducts {

    public int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            var product = 1;
            var j = 0;
            while (j < array.length) {
                if (j != i) {
                    product *= array[j];
                }
                j++;
            }
            products[i] = product;
        }

        return products;
    }

    public int[] arrayOfProductsOptimal(int[] array) {
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }


        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }

    public int[] arrayOfProductsOptimalConcise(int[] array) {
        int[] products = new int[array.length];

        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            products[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }

        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightRunningProduct;
            rightRunningProduct *= array[i];
        }

        return products;
    }

    @Test
    public void TestCase1() {
        var input = new int[] {5, 1, 4, 2};
        var expected = new int[] {8, 40, 10, 20};
        int[] actual = arrayOfProductsOptimalConcise(input);
        System.out.println(Arrays.toString(actual));
    }
}
