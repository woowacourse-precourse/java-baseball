package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PLAYER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_STATE_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String inputPlayerNumber() {
        System.out.print(INPUT_PLAYER_NUMBER);
        return Console.readLine();
    }

    public static String inputStateNumber() {
        System.out.println(INPUT_STATE_NUMBER);
        return Console.readLine();
    }
}
