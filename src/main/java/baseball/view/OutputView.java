package baseball.view;

import baseball.domain.dto.Score;

public final class OutputView {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String DELIMITER = " ";

    public void printResult(Score userScore) {
        printMessage(userScore);
    }

    private void printMessage(Score score) {
        if (score.isZeroPoint()) {
            System.out.println(NOTHING);
            return;
        }
        System.out.println(makeBallMessageIfExists(score.getBall()) +
                DELIMITER +
                makeStrikeMessageIfExists(score.getStrike()));
    }

    private String makeBallMessageIfExists(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL;
    }

    private String makeStrikeMessageIfExists(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE;
    }
}
