package algoexpert;

import org.junit.jupiter.api.Test;

public class CaesarCipherEncryptor {
    static int MAX_ALPHABET_ELEMENTS = 26;
    static int START_ALPHABET = 96;
    static int MAXIMUM_ALPHABET = 122;

    // O(n) time | O(n) space
    public static String caesarCypherEncryptor(String str, int key) {
        char[] result = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) + key > 'z') {
                var newLetterCode = str.charAt(i) + (key % MAX_ALPHABET_ELEMENTS);
                result[i] = (char) ((START_ALPHABET + newLetterCode) % MAXIMUM_ALPHABET);
            } else {
                result[i] = (char) (str.charAt(i) + key);
            }
        }
        return new String(result);
    }

    @Test
    public void TestCase1() {
        System.out.println(caesarCypherEncryptor("xyz", 2).equals("zab"));
    }
}
