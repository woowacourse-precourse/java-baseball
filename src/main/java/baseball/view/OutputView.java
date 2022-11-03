package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ANSWER_INPUT_GUIDE = "숫자를 입력해주세요 : ";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_STOP_GUIDE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printAnswerInputGuide() {
        System.out.println(ANSWER_INPUT_GUIDE);
    }

    public static void printGameEndMessage() {
        System.out.println(GAME_END);
    }

    public static void printRestartOrStopGuideMessage() {
        System.out.println(RESTART_OR_STOP_GUIDE);
    }
}
