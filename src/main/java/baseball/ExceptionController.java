package baseball;

public class ExceptionController {
    public static void handleInvalidThreeRandomNumber(String input) {
        handleNot3LengthInput(input);
        handleNotNumberInput(input);
        handleDuplicatedNumberInput(input);
    }

    private static void handleNot3LengthInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 수를 입력해야 합니다.");
        }
    }

    private static void handleNotNumberInput(String input) {
        for(int i = 0; i < 3; i++) {
            char character = input.charAt(i);
            if ((character < '0') || (character > '9')) {
                throw new IllegalArgumentException("숫자만 입력해야 합니다.");
            }
        }
    }

    private static void handleDuplicatedNumberInput(String input) {

    }
}
