package baseball.view;

import baseball.vo.Restart;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static final String NUMBER_INPUT_NUDGE_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String ASKING_RESTART_MESSAGE
            = String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
            Restart.RESTART.getValue(), Restart.EXIT.getValue());

    public String getUserInput() {
        System.out.print(NUMBER_INPUT_NUDGE_MESSAGE);
        return readInput();
    }

    public String getRestartingInput() {
        System.out.println(ASKING_RESTART_MESSAGE);
        return readInput();
    }

    protected String readInput() {
        return Console.readLine();
    }
}
