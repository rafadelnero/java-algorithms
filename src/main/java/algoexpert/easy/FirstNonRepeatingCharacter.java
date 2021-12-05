package algoexpert.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    // O(n) time | O(1) space
    public int firstNonRepeatingCharacter(String string) {
        Map<Character, MetaCharacter> characters = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            characters.put(string.charAt(i), characters.getOrDefault(string.charAt(i),
                    new MetaCharacter(0, i)).increaseCount());
        }

        return characters.values().stream()
                .filter(value -> value.count == 1)
                .map(value -> value.index)
                .findFirst().orElse(-1);
    }

    static class MetaCharacter {
        int count;
        int index;

        public MetaCharacter(int count, int index) {
            this.count = count;
            this.index = index;
        }

        MetaCharacter increaseCount() {
            count++;
            return this;
        }
    }

    // O(n) time | O(1) space that's because there will be only 26 characters in the alphabet
    public int firstNonRepeatingCharacterSimplerWay(String string) {
        Map<Character, Integer> characters = new LinkedHashMap<>();

        for (int i = 0; i < string.length(); i++) {
            characters.put(string.charAt(i), characters.getOrDefault(string.charAt(i), 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            if (characters.get(string.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }


    @Test
    public void TestCase1() {
//        String input = "";
        String input = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy";
        int expected = 1;
        var actual = firstNonRepeatingCharacterSimplerWay(input);
        System.out.println(actual);
    }
}
