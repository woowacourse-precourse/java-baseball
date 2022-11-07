package baseball.view;

import baseball.domain.GameLogic;

public class OutputView {
    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.println(INPUT_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
    }

    public static void printResult(GameLogic result) {
        System.out.println(result);
    }

    public static void printRestartOrEnd() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }
}
