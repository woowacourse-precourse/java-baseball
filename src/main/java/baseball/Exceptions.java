package baseball;

import java.util.HashSet;

public class Exceptions {
    public void checkLength(String s) {
        if (s.length() != Application.NUMBER_LENGTH()) {
            throw new IllegalArgumentException();
        }
    }

    public void checkType(String s) {
        try {
            int stringToInteger = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDuplication(String s) {
        HashSet<Character> WORD_SET = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (WORD_SET.contains(s.charAt(i))) {
                throw new IllegalArgumentException();
            }
            WORD_SET.add(s.charAt(i));
        }
    }
}
