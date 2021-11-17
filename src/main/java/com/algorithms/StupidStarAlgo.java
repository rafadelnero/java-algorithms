package com.algorithms;

public class StupidStarAlgo {

    public static void main(String[] args) {
        generateTriangle(5);
    }

    static void generateTriangle(int triangleSize) {
        for (int i = 1; i <= triangleSize; i++) {
            System.out.print(buildString(triangleSize - i, " "));
            System.out.print(buildString(i, "*"));
            System.out.println();
        }
    }

    static String buildString(int times, String character) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(character);
        }
        return result.toString();
    }
}
