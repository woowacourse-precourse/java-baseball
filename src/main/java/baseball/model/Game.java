package baseball.model;

import baseball.constants.Message;

public class Game {
    public boolean isRunning = true;
    private int countOfStrike = 0;
    private int countOfBall = 0;

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String compareBall(String playerBall, String computerBall) {
        resetCountOfBall();

        for (int i = 0; i < 3; i++) {
            checkStrikeCount(playerBall.charAt(i), computerBall, i);
        }

        return makeResultMessage();
    }

    private void resetCountOfBall() {
        this.countOfStrike = 0;
        this.countOfBall = 0;
    }

    private void checkStrikeCount(char playerBall, String computerBall, int index) {
        if (playerBall == computerBall.charAt(index)) {
            this.countOfStrike++;
            return;
        }

        for (int i = 0; i < 3; i++) {
            checkBallCount(playerBall, computerBall.charAt(i));
        }
    }

    private void checkBallCount(char playerBall, char computerBall) {
        if (playerBall == computerBall) {
            this.countOfBall++;
        }
    }

    private String makeResultMessage() {
        if (this.countOfStrike == 0 && this.countOfBall == 0) {
            return Message.NOTHING;
        }

        return makeBallCountMessage();
    }

    private String makeBallCountMessage() {
        if (this.countOfBall != 0 && this.countOfStrike == 0) {
            return this.countOfBall + Message.BALL;
        }

        if (this.countOfBall == 0 && this.countOfStrike != 0) {
            return this.countOfStrike + Message.STRIKE;
        }

        return this.countOfBall + Message.BALL + " " + this.countOfStrike + Message.STRIKE;
    }
}