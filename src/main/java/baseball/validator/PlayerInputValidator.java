package baseball.validator;

import java.util.ArrayList;
import java.util.List;

public class PlayerInputValidator {
    public static void inputValidate(String input) {
        isNumCheck(input);
        lengthCheck(input);
        duplicateCheck(input);
    }

    public static void isNumCheck(String input) throws IllegalArgumentException {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자인 값만 입력해야 합니다.");
            }
        }
    }

    public static void lengthCheck(String input) throws IllegalArgumentException {
        if (input.length() != 3) {
            throw new IllegalArgumentException("3자리 숫자만 입력해야 합니다.");
        }
    }

    public static void duplicateCheck(String input) throws IllegalArgumentException {
        List<Character> inputCheck = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char inputChar = input.charAt(i);
            if (inputCheck.contains(inputChar)) {
                throw new IllegalArgumentException("중복되는 숫자가 입력되었습니다.");
            }
            inputCheck.add(inputChar);
        }
    }

    public static void restartOrEndValidate(String input) throws IllegalArgumentException {
        if (!(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2만 입력해야 합니다.");
        }
    }
}
