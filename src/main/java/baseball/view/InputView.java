package baseball.view;

import baseball.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String USER_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    private static final String END_OR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_NUMBER = "1";

    public static String selectUserNumberInput() {
        System.out.print(USER_INPUT_MESSAGE);
        return InputException.validUserNumberException(Console.readLine());
    }

    public static boolean selectEndOrRestartInput() {
        System.out.println(END_OR_RESTART_MESSAGE);
        return getEndOrRestart(InputException.validRestartNumberException(Console.readLine()));
    }

    private static boolean getEndOrRestart(String restartNumber) {
        return restartNumber.equals(RESTART_NUMBER);
    }
}
