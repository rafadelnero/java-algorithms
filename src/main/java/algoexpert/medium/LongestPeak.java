package algoexpert.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestPeak {

    public static int longestPeak(int[] array) {
        List<Integer> peaksIndexes = findPeaks(array);
        return findHighestPeak(array, peaksIndexes);
    }

    private static List<Integer> findPeaks(int[] array) {
        List<Integer> peaksIndexes = new ArrayList<>();

        var increasing = false;
        var i = 0;

        while (i < array.length) {
            while (i + 1 < array.length && array[i] < array[i + 1]) {
                increasing = true;
                i++;
            }
            while (i + 1 < array.length && array[i] > array[i + 1] && increasing){
                peaksIndexes.add(i);
                increasing = false;
                i++;
            }

            if (i + 1 < array.length && array[i] == array[i + 1]) {
                increasing = false;
                i++;
            }

            if (!(i + 1 < array.length && array[i] < array[i + 1]) &&
                    !(i + 1 < array.length && array[i] > array[i + 1] && increasing) &&
                    !(i + 1 < array.length && array[i] == array[i + 1])) {
                i++;
            }
        }

        return peaksIndexes;
    }

    private static int findHighestPeak(int[] array, List<Integer> peaksIndexes) {
        List<Integer> peaks = new ArrayList<>();

        for (var eachPeak : peaksIndexes) {
            var peakSize = 3;
            var left = eachPeak - 1;
            var right = eachPeak + 1;
            while (left - 1 >= 0 && array[left - 1] < array[left]) {
                peakSize++;
                left--;
            }

            while (right + 1 < array.length && array[right] > array[right + 1]) {
                peakSize++;
                right++;
            }

            peaks.add(peakSize);
        }

        return peaks.isEmpty() ? 0 : Collections.max(peaks);
    }

    public static int longestPeakOptimized(int[] array) {
        var longestPeak = 0;
        var i = 1;

        while (i < array.length - 1) {
            var isPeak = array[i - 1] < array[i]  && array[i] > array[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }

            var left = i - 2;
            while (left >= 0 && array[left] < array[left + 1]) {
                left--;
            }

            var right = i + 2;
            while (right < array.length && array[right] < array[right - 1]) {
                right++;
            }

            var currentMaxPeak = right - left - 1;
            longestPeak = Math.max(longestPeak, currentMaxPeak);
            i = right;
        }

        return longestPeak;
    }

    @Test
    public void TestCase1() {
        var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        var expected = 6;
        var actual = longestPeakOptimized(input);
        System.out.println(actual);
    }

}
