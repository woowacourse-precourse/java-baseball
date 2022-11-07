package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String receiveInput() {
        System.out.print(INPUT_MESSAGE);
        String input = Console.readLine();
        Validation.checkInput(input);
        return input;
    }

    public static String restartOrEnd() {
        System.out.println(RESTART_OR_END_MESSAGE);
        String input = Console.readLine();
        Validation.isRestartOrEnd(input);
        return input;
    }
}
