package algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class NonConstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        // sort the array 1 1 2 3 5 7 22
        // add all numbers to a set
        // Traverse in the array
        // sum numbers and add them to the set
        // No need to go further than the max number
        // Verify if number is divisible?
        // Find the number that is greater than the change and verify if there is change behind this number
        // Use two for looping to verify all the possibilities if there is change put it into the set
        Arrays.sort(coins);

        outer:
        for (int i = 1; i < coins[coins.length - 1]; i++) {
            coins:
            for (int j = 0; j < coins.length; j++) {
                var sumOfChange = 0;
                for (int k = j + 1; k < coins.length; k++) {
                    if (i == coins[k] || i == coins[j]) {
                        continue outer;
                    } else if (coins[j] + coins[k] == i || sumOfChange == i) {
                        continue outer;
                    } else if (coins[j] + coins[k] > i) {
                        continue coins;
                    } else if (k == coins.length - 1 && j == coins.length - 1) {
                        return i;
                    } else {
                        sumOfChange += coins[j];
                    }
                }
            }
        }

        return -1;
    }

    // O(n log n) tim | O(1) space 1 1 2 3 5 7 22
    public static int nonConstructibleChangeUserSolution(int[] coins) {
        Map<String, String> map = new Hashtable<>();
        map.put(null, "value");
        Arrays.sort(coins);
        var currentChangeCreated = 0;

        for (var coin : coins) {
            if (coin > currentChangeCreated + 1) {
                return currentChangeCreated + 1;
            }

            currentChangeCreated += coin;
        }

        return currentChangeCreated + 1;
    }

    public static void main(String[] args) {
        System.out.println(nonConstructibleChangeUserSolution(new int[]{5, 7, 1, 1, 2, 3, 22}));
    }
}
