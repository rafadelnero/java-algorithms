package com.algorithms;

import java.util.Arrays;

public class OneWayEditString {

    public static void main(String[] args) {
        oneWayEditOneOrZero("ale", "pale");
    }

    static void oneWayEditOneOrZero(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();

        Arrays.sort(str1Chars);
        Arrays.sort(str2Chars);

        int minSize = Math.min(str1Chars.length, str2Chars.length);
    }

}
