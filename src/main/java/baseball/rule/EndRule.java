package baseball.rule;

import baseball.domain.BallCount;

public class EndRule {

    private static final String THREE_STRIKE = "3스트라이크";
    private static final String ONLY_INPUT_1_OR_2 = "1과 2만 입력 가능합니다";

    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";

    public static boolean isGameEnd(BallCount ballCount) {
        return ballCount.ballCountResult().equals(THREE_STRIKE);
    }

    public static boolean isProgramEnd(String userInput) {
        validateWrongNum(userInput);
        return userInput.equals(END_NUMBER);
    }

    private static void validateWrongNum(String userInput) {
        if (!userInput.equals(RESTART_NUMBER) && !userInput.equals(END_NUMBER)) {
            throw new IllegalArgumentException(ONLY_INPUT_1_OR_2);
        }
    }

}
