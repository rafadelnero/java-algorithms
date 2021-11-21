package com.algorithms;

public class IsPalindrome {

    public static void main(String[] args) {
//        System.out.println(isPalindrome("an a"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    static boolean isPalindrome(String word) {
        word = word.replaceAll(" |[^a-zA-Z0-9]", "");
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }
}
