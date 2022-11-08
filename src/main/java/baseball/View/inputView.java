package baseball.View;

import camp.nextstep.edu.missionutils.Console;


public class inputView {

    private static final String INPUT_MESSAGE = "숫자를 입력하세요";
    private static final String RESTART_OR_QUIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getUserAnswer() {
        System.out.println(INPUT_MESSAGE);
        return Console.readLine();
    }


    public static String getRestartOrQuit() {
        System.out.println(RESTART_OR_QUIT);
        return Console.readLine();
    }
}
