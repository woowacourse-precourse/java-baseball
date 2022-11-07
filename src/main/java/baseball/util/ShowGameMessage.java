package baseball.util;

import baseball.dto.ScoreResult;

public class ShowGameMessage {
    public void gameStartMessage() {
        System.out.println(GameMessage.START);
    }

    public void inputUserNumberMessage() {
        System.out.print(GameMessage.USER_INPUT);
    }

    public void gameResultMessage(ScoreResult scoreResult) {
        switch (scoreResult.getScoreResultType()) {
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
            case BALL_STRIKE:
                ballAndStrikeMessage(scoreResult.getBall(), scoreResult.getStrike());
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

    private void ballAndStrikeMessage(int ball, int strike) {
        System.out.printf(GameMessage.STRIKE_BALL, ball, strike);
    }

    private void continueGameMessage() {
        System.out.println(GameMessage.CONTINUE_GAME);
    }
}
