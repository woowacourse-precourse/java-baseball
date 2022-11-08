package baseball;

import java.util.HashSet;
import java.util.Set;

public class ExceptionController {
    public static void handleInvalidThreeRandomNumber(String input) {
        handleNot3LengthInput(input);
        handleNotNumberInput(input);
        handleDuplicatedNumberInput(input);
    }

    public static void handleInvalidFinishCode(String input) {
        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    private static void handleNot3LengthInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
        }
    }

    private static void handleNotNumberInput(String input) {
        for(int i = 0; i < 3; i++) {
            char character = input.charAt(i);
            if ((character < '1') || (character > '9')) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    private static void handleDuplicatedNumberInput(String input) {
        Set<Character> characterSet = new HashSet<>();

        for(int i = 0; i < 3; i++) {
            Character character = input.charAt(i);
            characterSet.add(character);
        }

        if (characterSet.size() != 3) {
            throw new IllegalArgumentException("서로 다른 세 개의 수를 입력해야 합니다.");
        }
    }
}
