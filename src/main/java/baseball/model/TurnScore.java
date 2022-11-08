package baseball.model;

import baseball.constant.ResultTurn;

public class TurnScore {
    private int balls;
    private int strikes;
    private ResultTurn resultTurn;

    public TurnScore() {
    }

    public TurnScore(int balls, int strikes, ResultTurn resultTurn) {
        this.balls = balls;
        this.strikes = strikes;
        this.resultTurn = resultTurn;
    }

    public int getBalls() {
        return this.balls;
    }

    public int getStrikes() {
        return this.strikes;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public ResultTurn getResultTurn() {
        return this.resultTurn;
    }

    public void setResultTurn() {
        if (checkIsOut()) {
            return;
        }
        if (checkIsNothing()) {
            return;
        }
        if (checkIsStrikesZero()) {
            this.resultTurn = ResultTurn.OnlyBalls;
            return;
        }
        if (checkIsBallsZero()) {
            this.resultTurn = ResultTurn.OnlyStrikes;
            return;
        }
        this.resultTurn = ResultTurn.StrikesAndBalls;
    }

    public boolean checkIsOut() {
        if (this.strikes == 3) {
            this.resultTurn = ResultTurn.Out;
            return true;
        }
        return false;
    }

    public boolean checkIsNothing() {
        if (checkIsBallsZero() && checkIsStrikesZero()) {
            this.resultTurn = ResultTurn.Nothing;
            return true;
        }
        return false;
    }

    public boolean checkIsBallsZero() {
        if (this.balls == 0) {
            return true;
        }
        return false;
    }

    public boolean checkIsStrikesZero() {
        if (this.strikes == 0) {
            return true;
        }
        return false;
    }

}
