package baseball;

import java.util.HashSet;

public class PlayerInputValidator {

    public static void validate(String input, int length) {
        if (input.length() != length) {
            throw new IllegalArgumentException("잘못된 입력값 입니다.");
        }

        HashSet<Character> characters = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (characters.contains(input.charAt(i)) || !Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("잘못된 입력값 입니다.");
            }
            characters.add(input.charAt(i));
        }
    }
}
