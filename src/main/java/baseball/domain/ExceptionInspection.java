package baseball.domain;

public class ExceptionInspection {
    public ExceptionInspection(String number) {
        inspectException(number);
    }

    private void inspectException(String input) {
        checkInteger(input);
        checkThreeNumbers(input);
        checkDuplicatedNumber(input);
    }

    private void checkDuplicatedNumber(String number) {
        char firstNumber = number.charAt(0);
        char secondNumber = number.charAt(1);
        char thirdNumber = number.charAt(2);
        if (firstNumber == secondNumber || secondNumber == thirdNumber || firstNumber == thirdNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void checkThreeNumbers(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void checkInteger(String inputWord) {
        for (int numberIndex = 0; numberIndex < inputWord.length(); numberIndex++) {
            if (inputWord.charAt(numberIndex) < '1' && inputWord.charAt(numberIndex) > '9') {
                throw new IllegalArgumentException();
            }
        }
    }
}