package baseball.view;

public final class Printer {

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "%d스트라이크";
    public static final String BALL = "%d볼";
    public static final String BALL_AND_STRIKE = "%d볼 %d스트라이크";

    private Printer() {
    }

    public static void printGameStart() {
        System.out.print(START_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public static void printGameEnd() {
        System.out.print(END_MESSAGE);
    }

    public static void printGameRestart() {
        System.out.print(RESTART_MESSAGE);
    }

    public static void printHintMessage(int ballCount, int strikeCount) {
        String hintMessage = buildHintMessage(ballCount, strikeCount);
        System.out.println(hintMessage);
    }

    private static String buildHintMessage(int ballCount, int strikeCount) {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        if (ballCount == 0) {
            return String.format(STRIKE, strikeCount);
        }
        if (strikeCount == 0) {
            return String.format(BALL, ballCount);
        }
        return String.format(BALL_AND_STRIKE, ballCount, strikeCount);
    }
}
