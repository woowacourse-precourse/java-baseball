package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputNumber() {
        String inputNumber = Console.readLine();
        validateInputNumber(inputNumber);
        return inputNumber;
    }

    private static void validateInputNumber(String inputNumber) {
        if (isInputNumberNotDigit(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력하는 수는 숫자여야합니다.");
        }
        if (isInputNumberLengthNotSame3(inputNumber)) {
            throw new IllegalArgumentException("[ERROR] : 입력하는 수는 3자리여야합니다.");
        }
    }

    private static boolean isInputNumberLengthNotSame3(String inputNumber) {
        return inputNumber.length() != 3;
    }

    private static boolean isInputNumberNotDigit(String inputNumber) {
        return !inputNumber.matches("^[0-9]*$");
    }
}
