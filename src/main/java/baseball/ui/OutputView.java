package baseball.ui;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private OutputView() {
    }

    public static void printGameStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printGameOverMessage() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    public static void printCompareResult(Result result) {
        System.out.println(result);
    }
}
