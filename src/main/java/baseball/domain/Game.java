package baseball.domain;


import static baseball.common.Constant.MAX_STRIKE_SIZE;

import static baseball.domain.Hint.*;
import static baseball.domain.GameStatus.*;

public final class Game {

    private int strike;

    private int ball;

    private GameStatus gameStatus;

    public Game() {
        this.gameStatus = GameStatus.PROGRESS;
    }

    public boolean isExitStatus() {
        return gameStatus.equals(EXIT);
    }

    public boolean isMaxStrike() {
        return strike == MAX_STRIKE_SIZE;
    }

    public void playBaseBall(Player player, Computer computer) {
        strike = Referee.findStrikeCount(player.getBalls(), computer.getBalls());
        ball = Referee.findBallCount(player.getBalls(), computer.getBalls());
    }

    public void clearResult() {
        strike = 0;
        ball = 0;
    }

    public void setExitStatus(){
        this.gameStatus = EXIT;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return NOTHING.symbol();
        }

        if (strike == 0) {
            return ball + BALL.symbol();
        }

        if (ball == 0) {
            return strike + STRIKE.symbol();
        }

        return ball + BALL.symbol() + " " + strike + STRIKE.symbol();
    }
}
