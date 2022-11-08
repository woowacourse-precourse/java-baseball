package baseball;

public class OutputView {
    public static final String MESSAGE_BALL = "%d볼";
    public static final String MESSAGE_STRIKE = "%d스트라이크";
    public static final String MESSGAE_FOUR_BALL = "볼넷";
    public static final String MESSGAE_NOTHING = "낫싱";
    public static final String MESSAGE_VICTORY = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void showOnlyBallResult(int ball) {
        System.out.println(String.format(MESSAGE_BALL, ball));
    }

    public static void showOnlyStrikeResult(int strike) {
        System.out.println(String.format(MESSAGE_STRIKE, strike));
    }

    public static void showBallAndStrikeResult(int ball, int strike) {
        System.out.println(String.format(MESSAGE_BALL + " " + MESSAGE_STRIKE, ball, strike));
    }

    public static void showFourBallResult() {
        System.out.println(MESSGAE_FOUR_BALL);
    }

    public static void showVictoryMessage() {
        System.out.println(MESSAGE_VICTORY);
    }

    public static void showBallAndStrikeNothing() {
        System.out.println(MESSGAE_NOTHING);
    }
}