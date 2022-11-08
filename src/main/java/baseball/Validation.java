package baseball;

import java.util.HashSet;

public class Validation {
    public static void validateBaseballInput(String input) {
        if (hasSameWord(input) || hasNonDigit(input) || hasSameWord(input)) {
            throw new IllegalArgumentException("입력오류");
        }
    }

    public static boolean hasNonDigit(String input) {
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasSameWord(String input) {
        HashSet<Character> inputToHashSet = new HashSet<>();

        stringToHashSet(input, inputToHashSet);

        return input.length() != inputToHashSet.size();
    }

    public static void stringToHashSet(String input, HashSet<Character> inputToHashSet) {
        for (int i = 0; i < input.length(); i++) {
            inputToHashSet.add(input.charAt(i));
        }
    }

    public static void validateResetInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("입력오류");
        }
    }
}
