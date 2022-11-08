package baseball;

import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;

public class GameResult {

    private final static String NOTHING = "낫싱";
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    // 1볼 1스트라이크
    public boolean isFinished() {
        return strikeCount == GAME_NUMBER_LENGTH;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }

    public int getBallCount() {
        return this.ballCount;
    }

    @Override
    public String toString() {
        StringBuilder gameResultMessage = new StringBuilder();
        makeBallMessage(gameResultMessage);
        makeStrikeMessage(gameResultMessage);
        makeNothingMessage(gameResultMessage);
        gameResultMessage.append("\n");
        return gameResultMessage.toString();
    }

    private void makeBallMessage(StringBuilder gameResultMessage) {
        if (ballCount > 0) {
            gameResultMessage.append(ballCount);
            gameResultMessage.append(BALL);
        }
    }

    private void makeStrikeMessage(StringBuilder gameResultMessage) {
        if (gameResultMessage.length() > 0) {
            gameResultMessage.append(" ");
        }
        if (strikeCount > 0) {
            gameResultMessage.append(strikeCount);
            gameResultMessage.append(STRIKE);
        }
    }

    private void makeNothingMessage(StringBuilder gameResultMessage) {
        if (gameResultMessage.length() == 0) {
            gameResultMessage.append(NOTHING);
        }
    }
}
