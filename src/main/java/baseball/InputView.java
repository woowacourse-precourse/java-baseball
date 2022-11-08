package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputBallNumber() {
        System.out.print(MessageUtils.INPUT_NUMBER_MESSAGE);
        return validateBallNumberSize(Console.readLine());
    }

    private static String validateBallNumberSize(String ballNumber) {
        if (ballNumber.length() != MessageUtils.BALL_SET_SIZE) {
            throw new IllegalArgumentException(MessageUtils.NUMBER_SIZE_OUT_OF_RANGE_MESSAGE);
        }
        return ballNumber;
    }

    public static String inputPlayNumber() {
        return validateIsProperNumber(Console.readLine());
    }

    private static String validateIsProperNumber(String playNumber) {
        if (!playNumber.equals(MessageUtils.START_TEXT) && !playNumber.equals(MessageUtils.FINISH_TEXT)) {
            throw new IllegalArgumentException(MessageUtils.NOT_PROPER_INPUT_MESSAGE);
        }
        return playNumber;
    }
}