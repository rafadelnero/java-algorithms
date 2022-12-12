package algoexpert.easy;

public class Palindrome {

    public static boolean isPalindrome(String str) {
        return reverseString(str).equals(str);
    }

    private static String reverseString(String str) {
        StringBuilder reversedStr = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr.append(str.charAt(i));
        }
        return reversedStr.toString();
    }

    public static boolean isPalindromeRecursion(String str) {
        return isPalindromeRecursionHelper(str, 0);
    }

    // O(n) time | O(n) space
    private static boolean isPalindromeRecursionHelper(String str, int i) {
        var j = str.length() - i - 1;
        if (i >= j) {
            return true;
        }

        if (str.charAt(i) != str.charAt(j)) {
            return false;
        }

        return isPalindromeRecursionHelper(str, ++i);
    }

    // O(n) time | O(1) space
    private static boolean isPalindromePointerSolution(String str) {
        int leftIndex = 0;
        int rightIndex = str.length() - 1;

        while (leftIndex < rightIndex) {
            if (str.charAt(leftIndex) != str.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome("ana"));
//        System.out.println(isPalindromeRecursion("ana"));
        System.out.println(isPalindromePointerSolution("ana"));
    }
}
