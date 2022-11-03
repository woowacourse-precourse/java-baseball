package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String EXPECTED_NUMBER_OF_USER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String VALUE_OF_RESTART_GAME_OR_NOT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getExpectedNumberOfUser() {
        System.out.print(EXPECTED_NUMBER_OF_USER_MESSAGE);
        String expectedNumberOfUser = Console.readLine();
        return InputException.isValidInput(expectedNumberOfUser);
    }

    public static String getValueOfRestartGameOrNot() {
        System.out.println(VALUE_OF_RESTART_GAME_OR_NOT_MESSAGE);
        String valueOfRestartGameOrNot = Console.readLine();
        return InputException.isOneOrTwo(valueOfRestartGameOrNot);
    }
}
