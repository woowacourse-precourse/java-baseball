package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String NUMBER_INPUT_NUDGE_MESSAGE = "숫자를 입력해주세요 : ";

    public String getUserInput() {
        System.out.print(NUMBER_INPUT_NUDGE_MESSAGE);
        return Console.readLine();
    }
}
