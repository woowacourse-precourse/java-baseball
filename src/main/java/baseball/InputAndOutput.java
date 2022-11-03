package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputAndOutput {

    private static final String ANSWER_REQUEST_PHRASE = "숫자를 입력해주세요 : ";
    private static final String RESTART_OR_END_PHRASE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getUserAnswer() {
        System.out.print(ANSWER_REQUEST_PHRASE);
        return Console.readLine();
    }

    public static String getRestartOrEnd() {
        System.out.println(RESTART_OR_END_PHRASE);
        return Console.readLine();
    }
}
