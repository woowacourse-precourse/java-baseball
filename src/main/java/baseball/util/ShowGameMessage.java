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
        switch (scoreResult.getType()) {
            case ALL_STRIKE:
                strikeMessage(scoreResult.getStrike());
                allStrikeMessage();
                continueGameMessage();
                break;
            case STRIKE:
                strikeMessage(scoreResult.getStrike());
                break;
            case BALL:
                ballMessage(scoreResult.getBall());
                break;
            case STRIKE_BALL:
                strikeAndBallMessage(scoreResult.getStrike(), scoreResult.getBall());
                break;
            case NOTHING:
                nothingMessage();
                break;
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
