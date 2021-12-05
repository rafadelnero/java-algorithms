package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {
        var charactersArray = characters.toCharArray();
        var documentArray = document.toCharArray();

        List<Integer> ignoreIndexes = new ArrayList<>();

        for (int i = 0; i < documentArray.length; i++) {
            for (int j = 0; j < charactersArray.length; j++) {
                if (documentArray[i] == charactersArray[j] && !ignoreIndexes.contains(j)) {
                    documentArray[i] = ' ';
                    ignoreIndexes.add(j);
                    break;
                }
            }
            if (ignoreIndexes.size() <= i) {
                return false;
            }
        }

        return true;
    }

    // O(n + m) time | O(c) n == size of characters, m size of the document, c size of unique characters
    public static boolean generateDocumentMapSolution(String characters, String document) {
        Map<Character, Integer> charactersCount = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            charactersCount.put(characters.charAt(i), charactersCount.getOrDefault(characters.charAt(i), 0) + 1);
        }

        for (int i = 0; i < document.length(); i++) {
            if (charactersCount.containsKey(document.charAt(i))) {
                charactersCount.put(document.charAt(i), charactersCount.get(document.charAt(i)) - 1);

                if (charactersCount.get(document.charAt(i)) < 0)  {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    @Test
    public void TestCase1() {
        String characters = "Bste!hetsi  ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        var actual = generateDocumentMapSolution(characters, document);
        System.out.println(expected == actual);
    }

    @Test
    public void TestCase2() {
        String characters = "&*&you^a%^&8766 _=-09     docanCMakemthisdocument";
        String document = "Can you make this document &";
        boolean expected = true;
        var actual = generateDocumentMapSolution(characters, document);
        System.out.println(expected == actual);
    }

    @Test
    public void TestCase3() {
        String characters = "helloworldO";
        String document = "hello wOrld";
        boolean expected = true;
        var actual = generateDocumentMapSolution(characters, document);
        System.out.println(expected == actual);
    }
}
