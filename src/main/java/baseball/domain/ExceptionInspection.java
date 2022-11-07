package baseball.domain;

public class ExceptionInspection {
    static void inspectException(String input) {
        checkInteger(input);
        checkThreeNumbers(input);
        checkDuplicatedNumber(input);
    }

    private static void checkDuplicatedNumber(String number) {
        char firstNumber = number.charAt(0);
        char secondNumber = number.charAt(1);
        char thirdNumber = number.charAt(2);
        if (firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkThreeNumbers(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInteger(String inputWord) {
        for (int numberIndex = 0; numberIndex < inputWord.length(); numberIndex++) {
            if (inputWord.charAt(numberIndex) < '1' && inputWord.charAt(numberIndex) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}