package baseball;

public class OutputView {
    public static final String MESSAGE_BALL = "%d 볼";
    public static final String MESSAGE_STRIKE = "%d 스트라이크";
    public static final String MESSGAE_FOUR_BALL = "볼넷";
    public static final String MESSAGE_VICTORY = "3개의 숫자를 모두 맞히셨습니다! 당신의 승리입니다.";

    public static void showOnlyBallResult(BaseballScore baseballScore) {
        System.out.println(String.format(MESSAGE_BALL, baseballScore.getBall()));
    }

    public static void showOnlyStrikeResult(BaseballScore baseballScore) {
        System.out.println(String.format(MESSAGE_STRIKE, baseballScore.getStrike()));
    }

    public static void showStrikeAndBallResult(BaseballScore baseballScore) {
        System.out.println(String.format(MESSAGE_BALL + " " + MESSAGE_STRIKE, baseballScore.getBall(), baseballScore.getStrike()));
    }

    public static void showFourBallResult() {
        System.out.println(MESSGAE_FOUR_BALL);
    }

    public static void showVictoryMessage() {
        System.out.println(MESSAGE_VICTORY);
    }
}