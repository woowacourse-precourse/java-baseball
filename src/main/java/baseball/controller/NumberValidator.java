package baseball.controller;

public class NumberValidator {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String WRONG_LENGTH_INPUT_MESSAGE = "세 자리까지만 입력 가능합니다.";

    public void toValidateData(String inputNumber) {
        if (!isTreeLetters(inputNumber)) {
            throw new IllegalArgumentException(WRONG_LENGTH_INPUT_MESSAGE);
        }
    }

    public boolean isTreeLetters(String inputNumber) {
        return inputNumber.length() == BASEBALL_GAME_NUMBER_LENGTH;
    }
}
