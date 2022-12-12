package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ClassPhotos {

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        boolean isRedBehind = Collections.max(redShirtHeights) > Collections.max(blueShirtHeights);

        redShirtHeights.sort(Comparator.reverseOrder());
        blueShirtHeights.sort(Comparator.reverseOrder());

        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (isRedBehind) {
                if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                    return false;
                }
            } else {
                if (blueShirtHeights.get(i) <= redShirtHeights.get(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void TestCase1() {
//        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
//        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));

        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4, 9));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5, 1));
        boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(actual);
    }
}
