package baseball.rule;

import baseball.domain.BallCount;
import baseball.util.Validator;

public class EndRule {

    private static final String THREE_STRIKE = "3스트라이크";
    private static final String END_NUMBER = "2";

    public static boolean isGameEnd(BallCount ballCount) {
        return ballCount.ballCountResult().equals(THREE_STRIKE);
    }

    public static boolean isProgramEnd(String userInput) {
        Validator.validateWrongNum(userInput);
        return userInput.equals(END_NUMBER);
    }
}
