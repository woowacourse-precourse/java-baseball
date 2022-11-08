package baseball;

import static baseball.BaseBallGame.GAME_NUMBER_LENGTH;

public class GameResult {

    private final static String NOTHING = "낫싱";
    private final static String BALL = "볼";
    private final static String STRIKE = "스트라이크";
    private final static String CR = "\n";
    private final static String SPACE = " ";
    private final static int EMPTY = 0;
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
        gameResultMessage.append(CR);
        return gameResultMessage.toString();
    }

    private void makeBallMessage(StringBuilder gameResultMessage) {
        if (ballCount > EMPTY) {
            gameResultMessage.append(ballCount);
            gameResultMessage.append(BALL);
        }
    }

    private void makeStrikeMessage(StringBuilder gameResultMessage) {
        if (gameResultMessage.length() > EMPTY) {
            gameResultMessage.append(SPACE);
        }
        if (strikeCount > EMPTY) {
            gameResultMessage.append(strikeCount);
            gameResultMessage.append(STRIKE);
        }
    }

    private void makeNothingMessage(StringBuilder gameResultMessage) {
        if (gameResultMessage.length() == EMPTY) {
            gameResultMessage.append(NOTHING);
        }
    }
}
