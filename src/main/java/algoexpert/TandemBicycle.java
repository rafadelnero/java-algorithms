package algoexpert;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TandemBicycle {

    // Greedy algorithm - when you sort arrays to get the solution.
    // O nlog(n) time | O(1) space
    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        var tandemBicycleSpeed = 0;

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (fastest) {
                var maxRed = Math.max(blueShirtSpeeds[i], redShirtSpeeds[blueShirtSpeeds.length - 1 - i]);
                tandemBicycleSpeed += maxRed;
            } else {
                tandemBicycleSpeed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }

        return tandemBicycleSpeed;
    }

    @Test
    public void TestCase1() {
        int[] redShirtSpeeds = new int[]{5, 5, 3, 9, 2}; // 9 5 5 3 2  - 8 + 5 + 3 + 3 + 2
        int[] blueShirtSpeeds = new int[]{3, 6, 7, 2, 1}; // 7 6 3 2 1
        boolean fastest = true;
        int expected = 32;
        var actual = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        System.out.println(actual);
    }
}
