package baseball.rule;

import baseball.domain.BallCount;

public class EndRule {

    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";

    public static boolean isGameEnd(BallCount ballCount) {
        return ballCount.ballCountResult().equals("3스트라이크");
    }

    public static boolean isProgramEnd(String userInput) {
        return userInput.equals(END_NUMBER);
    }

}
