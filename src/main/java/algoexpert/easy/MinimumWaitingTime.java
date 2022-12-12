package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MinimumWaitingTime {

    // O(n log n) time | O(1) space
    public int minimumWaitingTime(int[] queries) {
        if (queries.length == 1) {
            return 0;
        }

        Arrays.sort(queries);
        var result = 0;
        var j = 0;

        for (int i = 1; i < queries.length; i++) {
            j = i - 1;
            while (j >= 0) {
                result += queries[j];
                j--;
            }

        }
        return result;
    }

    // O (n log n) time | O (1) space
    public int minimumWaitingTimeUserSolution(int[] queries) {
        Arrays.sort(queries);

        int totalWaitingTime = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            totalWaitingTime += duration * queriesLeft;
        }

        return totalWaitingTime;
    }

    @Test
    public void TestCase1() {
        // 1, 2, 2, 3, 6
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        var actual = minimumWaitingTimeUserSolution(queries);
        System.out.println(actual);
    }
}
