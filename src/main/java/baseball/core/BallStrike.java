package baseball.core;

import java.util.List;

public class BallStrike {

    private static final String NOTHING = "낫싱";
    private static final String BALL = "%d볼";
    private static final String STRIKE = "%d스트라이크";

    private final int ballCount;
    private final int strikeCount;

    public BallStrike(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    @Override
    public String toString() {
        return getScoreMessage();
    }

    private String getScoreMessage() {
        String resultMessage;

        if (isNothing()) {
            resultMessage = getNothingMessage();
        } else {
            resultMessage = getBallStrikeResultString();
        }
        return resultMessage;
    }

    private boolean isNothing() {
        return ballCount == 0 && strikeCount == 0;
    }

    private String getNothingMessage() {
        return NOTHING;
    }

    private String getBallStrikeResultString() {
        String ballString = getBallString();
        String strikeString = getStrikeString();
        return toResultMessage(ballString, strikeString);
    }

    private String getStrikeString() {
        String strikeString = "";
        if (strikeCount != 0) {
            strikeString = String.format(STRIKE, strikeCount);
        }
        return strikeString;
    }

    private String getBallString() {
        String ballString = "";
        if (ballCount != 0) {
            ballString = String.format(BALL, ballCount);
        }
        return ballString;
    }

    private static String toResultMessage(String ballString, String strikeString) {
        return String.join(" ", List.of(ballString, strikeString)).trim();
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
