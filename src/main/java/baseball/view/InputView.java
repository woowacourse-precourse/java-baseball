package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String INPUT_MESSAGE_ENTER_USER_INPUT = "숫자를 입력해주세요 : ";

    public static String receiveUserInput() {
        System.out.print(INPUT_MESSAGE_ENTER_USER_INPUT);
        return Console.readLine();
    }
}
