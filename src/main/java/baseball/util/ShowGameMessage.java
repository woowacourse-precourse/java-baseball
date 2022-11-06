package baseball.util;

import baseball.dto.ScoreResultType;
import baseball.dto.ScoreResult;

public class ShowGameMessage {
    public void gameStartMessage() {
        System.out.println(GameMessage.START);
    }

    public void inputUserNumberMessage() {
        System.out.print(GameMessage.USER_INPUT);
    }

    public void gameResultMessage(ScoreResult scoreResult) {
        if (scoreResult.getType() == ScoreResultType.ALL_STRIKE) {
            strikeMessage(scoreResult.getStrike());
            allStrikeMessage();
            continueGameMessage();
        } else if (scoreResult.getType() == ScoreResultType.STRIKE) {
            strikeMessage(scoreResult.getStrike());
        } else if (scoreResult.getType() == ScoreResultType.BALL) {
            ballMessage(scoreResult.getBall());
        } else if (scoreResult.getType() == ScoreResultType.STRIKE_BALL) {
            strikeAndBallMessage(scoreResult.getStrike(), scoreResult.getBall());
        } else {
            nothingMessage();
        }
    }

    private void allStrikeMessage() {
        System.out.println(GameMessage.ALL_STRIKE);
    }

    private void nothingMessage() {
        System.out.println(GameMessage.NOTHING);
    }

    private void ballMessage(int ball) {
        System.out.printf(GameMessage.BALL, ball);
    }

    private void strikeMessage(int strike) {
        System.out.printf(GameMessage.STRIKE, strike);
    }

    private void strikeAndBallMessage(int strike, int ball) {
        System.out.printf(GameMessage.STRIKE_BALL, strike, ball);
    }

    private void continueGameMessage() {
        System.out.println(GameMessage.CONTINUE_GAME);
    }
}
