package algoexpert.easy;

import org.junit.jupiter.api.Test;

public class RunLengthEncoding {

    public String runLengthEncoding(String string) {
        StringBuilder result = new StringBuilder();
        var letterCount = 0;
        Character currentLetter;
        Character nextLetter;

        for (int i = 0; i < string.length(); i++) {
            letterCount++;
            currentLetter = string.charAt(i);
            nextLetter = string.length() - 1 >= i + 1 ? string.charAt(i + 1) : null;

            if (!(currentLetter == nextLetter) || letterCount == 9) {
                result.append(letterCount).append(currentLetter);
                letterCount = 0;
            }
        }

        return result.toString();
    }

    public String runLengthEncodingUserSolution(String string) {
        StringBuilder result = new StringBuilder();
        int currentRunLength = 0;

        for (int i = 1; i < string.length(); i++) {
            char currentChar = string.charAt(i);
            char previousChar = string.charAt(i - 1);

            if (currentChar != previousChar || currentRunLength == 9) {
                result.append(currentRunLength);
                result.append(previousChar);
                currentRunLength = 0;
            }

            currentRunLength++;
        }

        result.append(currentRunLength);
        result.append(string.charAt(string.length() - 1));

        return result.toString();
    }

    @Test
    public void TestCase1() {
        var input = "AAAAAAAAAAAAABBCCCCDD";
//        var input = "                          ";
//        var input = "CCCDD";
//        var input = "aA";
        var expected = "9A4A2B4C2D";
        var actual = runLengthEncodingUserSolution(input);
        System.out.println(actual);
    }
}
