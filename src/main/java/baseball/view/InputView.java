package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private final static String INPUT_RESTART_OR_STOP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final static String invalidInputMessage = "재시작은 1, 종료는 2를 입력해야 합니다. ";

    private final static String RESTART = "1";
    private final static String STOP = "2";

    public static String playerInputNumber() {
        System.out.println(INPUT_NUMBER);

        String playerNumber = Console.readLine();
        return playerNumber;
    }

    public static Boolean isGameRestart() {
        System.out.println(INPUT_RESTART_OR_STOP);

        String restart = Console.readLine();
        if (restart.equals(RESTART)) return true;
        if (restart.equals(STOP)) return false;
        throw new IllegalArgumentException(invalidInputMessage); // 예외 처리
    }
}