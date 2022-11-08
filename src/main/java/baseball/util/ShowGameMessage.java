package baseball.util;

import baseball.dto.ScoreResult;

public class ShowGameMessage {
    public void gameStart() {
        System.out.println(GameMessage.START);
    }

    public void inputUserNumber() {
        System.out.print(GameMessage.ENTER_NUMBER);
    }

    public void gameResult(ScoreResult scoreResult) {
        switch (scoreResult.getScoreResultType()) {
            case ALL_STRIKE:
                strike(scoreResult.getStrike());
                threeStrike();
                endGame();
                break;
            case STRIKE:
                strike(scoreResult.getStrike());
                break;
            case BALL:
                ball(scoreResult.getBall());
                break;
            case BALL_STRIKE:
                ballAndStrike(scoreResult.getBall(), scoreResult.getStrike());
                break;
            case NOTHING:
                nothing();
                break;
        }
    }

    private void threeStrike() {
        System.out.println(GameMessage.THREE_STRIKE);
    }

    private void nothing() {
        System.out.println(GameMessage.NOTHING);
    }

    private void ball(int ball) {
        System.out.printf(GameMessage.BALL, ball);
    }

    private void strike(int strike) {
        System.out.printf(GameMessage.STRIKE, strike);
    }

    private void ballAndStrike(int ball, int strike) {
        System.out.printf(GameMessage.BALL_STRIKE, ball, strike);
    }

    private void endGame() {
        System.out.println(GameMessage.ENTER_CONTINUE_NUMBER_OR_EXIT_NUMBER);
    }
}
