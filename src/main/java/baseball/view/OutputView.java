package baseball.view;

import baseball.constant.Config;

public class OutputView {
    public static final String START = "숫자 야구 게임을 시작합니다.";
    public static final String SHUTDOWN = "게임 종료";
    public static final String GAME_OVER = Config.MAX_STRIKE + "개의 숫자를 모두 맞히셨습니다! " + SHUTDOWN;

    public static void printStart() {
        System.out.println(START);
    }

    public static void printHintMessage(String hintMessage) {
        System.out.println(hintMessage);
    }

    public static void printGameOver() {
        System.out.println(GAME_OVER);
    }

    public static void printShutdown() {
        System.out.println(SHUTDOWN);
    }
}
