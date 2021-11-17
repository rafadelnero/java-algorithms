package algoexpert;

import java.util.HashSet;
import java.util.Set;

public class SingleCycleCheck {

    public static boolean hasSingleCycle(int[] array) {
        Set<Integer> cycles = new HashSet<>();

        int i = 0;
        while (cycles.size() < array.length) {
            if (!cycles.add(i)) {
                break;
            }
            if (i + array[i] > array.length - 1) {
                i = (array[i] + array.length) % array.length;
            } else if (array[i] >= 0) {
                i = i + array[i];
            } else {
                var nextIndex = (array[i] + array.length) % array.length;
                i = nextIndex + array.length;
            }
        }

        return cycles.size() == array.length && i == 0;
    }

    public static boolean hasSingleCycleUserSolution(int[] array) {
        int numElementsVisited = 0;
        int currentIndex = 0;

        while (numElementsVisited < array.length) {
            if (numElementsVisited > 0 && currentIndex == 0) {
                return false;
            }
            numElementsVisited += 1;
            currentIndex = getNextIndex(currentIndex, array);
        }

        return currentIndex == 0;
    }
    // It's possible to easily wrap up in the array positions with the mod operator
    private static int getNextIndex(int currentIndex, int[] array) {
        int jump = array[currentIndex];
        int nextIndex = (currentIndex + jump) % array.length;
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycleUserSolution(new int[]{2, 3, 1, -4, -4, 2}));
//        System.out.println(hasSingleCycleUserSolution(new int[]{-26, 3, 1, -4, -4, 2}));
//        System.out.println(hasSingleCycle(new int[]{2, 2, -1}));
//        System.out.println(hasSingleCycle(new int[]{1, 1, 1, 1, 2}));
    }

}
