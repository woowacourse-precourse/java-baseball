package baseball;

import java.util.HashSet;

public class Validation {
    public static void baseballInput(String input) {
        if ((input.length() != Application.GAME_SIZE) || hasNotFromOneToNine(input) || hasSameWord(input)) {
            throw new IllegalArgumentException("입력오류");
        }
    }

    public static boolean hasNotFromOneToNine(String input) {
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if ((c < '1') || ('9' < c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasSameWord(String input) {
        HashSet<Character> inputToHashSet = new HashSet<>();

        inputToHashSet(input, inputToHashSet);

        return input.length() != inputToHashSet.size();
    }

    public static void inputToHashSet(String input, HashSet<Character> inputToHashSet) {
        for (int i = 0; i < input.length(); i++) {
            inputToHashSet.add(input.charAt(i));
        }
    }

    public static void resultInput(String input) {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("입력오류");
        }
    }
}
