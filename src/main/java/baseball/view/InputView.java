package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String NUMBER_INPUT_NUDGE_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String ASKING_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getUserInput() {
        System.out.print(NUMBER_INPUT_NUDGE_MESSAGE);
        return Console.readLine();
    }

    public String getRestartingInput() {
        System.out.println(ASKING_RESTART_MESSAGE);
        return Console.readLine();
    }
}
