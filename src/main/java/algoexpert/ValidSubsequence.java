package algoexpert;

import java.util.List;

public class ValidSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Traverse the array with a while looping
        // Use brute force solution
        // traverse in the sequence array - verify each element - return false if number is not found
        // If number is found, set the index of the array, change the index to the next index of the found element
        // use a while looping for the array - use an index that will be controlled in the sequence
        // Update index as the number is found in the sequence array
        // if all elements are found, return true
        int j = 0;
        int foundElements = 0;

        outer:
        for (Integer integer : sequence) {
            while (j < array.size()) {
                if (integer.equals(array.get(j))) {
                    foundElements++;
                    j++;
                    continue outer;
                }
                if (j == array.size() - 1) {
                    return false;
                }
                j++;
            }
        }
        return foundElements == sequence.size();
    }

    public static boolean isValidSubsequenceWhileSolution(List<Integer> array, List<Integer> sequence) {
        var arrayIndex = 0;
        var sequenceIndex = 0;

        while (arrayIndex < array.size() && sequenceIndex < sequence.size()) {
            if (array.get(arrayIndex).equals(sequence.get(sequenceIndex))) {
               sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.size();
    }


    public static boolean isValidSubsequenceForSolution(List<Integer> array, List<Integer> sequence) {
        var sequenceIndex = 0;

        for (var value : array) {
            if (sequenceIndex == sequence.size()) {
                break;
            }
            if (sequence.get(sequenceIndex).equals(value)) {
                sequenceIndex++;
            }
        }
        return sequenceIndex == sequence.size();
    }

    public static void main(String[] args) {
        System.out.println(isValidSubsequence(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10)));
        System.out.println(isValidSubsequenceForSolution(List.of(5, 1, 22, 25, 6, -1, 8, 10), List.of(1, 6, -1, 10)));
//        System.out.println(isValidSubsequence(List.of(1, 1, 6, 1), List.of(1, 1, 1, 6)));
        System.out.println(isValidSubsequenceWhileSolution(List.of(1, 1, 6, 1), List.of(1, 1, 1, 6)));
    }
}
