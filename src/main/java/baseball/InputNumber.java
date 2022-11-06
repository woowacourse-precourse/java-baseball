package baseball;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    static final int GAME_NUMBER_LENGTH = 3;
    static final int RESTART_NUMBER_LENGTH = 1;
    static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*$");
    static final Pattern RESTART_NUMBER_PATTERN = Pattern.compile("^[1-2]*$");

    public String inputGameNumber() {
        String inputNumber = Console.readLine();

        if (!gameNumberExceptionCheck(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }

    public String inputRestartNumber() {
        String inputNumber = Console.readLine();

        if (!restartNumberExceptionCheck(inputNumber)) {
            throw new IllegalArgumentException();
        }

        return inputNumber;
    }

    /**
     * @param inputNumber 사용자가 입력한 변수
     *                    사용자가 입력한 변수가 1글자여야만 하고,
     *                    1,2만을 받아들여야만 하여 정규식을 사용하여 예외처리를 해줌.
     */
    private boolean restartNumberExceptionCheck(String inputNumber) {
        if (inputNumber.length() == RESTART_NUMBER_LENGTH) {
            Matcher matchNum = RESTART_NUMBER_PATTERN.matcher(inputNumber);
            return matchNum.find();
        }
        return false;
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
