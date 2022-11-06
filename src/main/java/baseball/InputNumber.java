package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    static final int GAME_NUMBER_LENGTH = 3;
    static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");

    public String inputGameNumber() {
        String inputNumber = Console.readLine();

        if (!gameNumberExceptionCheck(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }

    /**
     * @param inputNumber 사용자가 입력한 변수
     *                    사용자가 입력한 변수가 3글자여야만 하고,
     *                    숫자만을 받아들여야만 하여 정규식을 사용하여 예외처리를 해줌.
     */
    private boolean gameNumberExceptionCheck(String inputNumber) {
        if (inputNumber.length() == GAME_NUMBER_LENGTH) {
            Matcher matchNum = NUMBER_PATTERN.matcher(inputNumber);
            return matchNum.find();
        }
        return false;
    }

}
