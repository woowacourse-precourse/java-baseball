package baseball.domain;

public class GameResult {

    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼";
    private static final String NOTHING = "낫싱";
    private static final String DELIMITER = " ";

    private final StringBuilder message = new StringBuilder();

    public GameResult(BaseballGame baseballGame) {
        makeMessage(baseballGame.getBallCount(), baseballGame.getStrikeCount());
    }

    private void makeMessage( int ballCount, int strikeCount) {
        makeBallMessage(ballCount);
        if (ballCount != 0 && strikeCount != 0) {
            message.append(DELIMITER);
        }
        makeStrikeMessage(strikeCount);
        makeNothingMessage(strikeCount, ballCount);
    }

    private void makeBallMessage(int ballCount) {
        if (ballCount != 0) {
            message.append(String.format(BALL, ballCount));
        }
    }

    private void makeStrikeMessage(int strikeCount) {
        if (strikeCount != 0) {
            message.append(String.format(STRIKE, strikeCount));
        }
    }

    private void makeNothingMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            message.append(NOTHING);
        }
    }

    public String getMessage() {
        return message.toString();
    }
}
