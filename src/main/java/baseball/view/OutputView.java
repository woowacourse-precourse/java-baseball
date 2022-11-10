package baseball.view;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_NESSAGE = "낫싱";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXIT_MESSAGE = "게임종료";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printOnlyStrikeMessage(int strike) {
        System.out.println(strike + STRIKE_MESSAGE);
    }

    public static void printOnlyBallMessage(int ball) {
        System.out.println(ball + BALL_MESSAGE);
    }

    public static void printHintMessage(int strike, int ball) {
        System.out.println(strike + STRIKE_MESSAGE + " " + ball + BALL_MESSAGE);
    }

    public static void printNothingMessage() {
        System.out.println(NOTHING_NESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public static void printReStartMessage() {
        System.out.println(RESTART_MESSAGE);
    }

    public static void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }
}
