package baseball.model;

import baseball.type.ResultTurn;

public class TurnScore {
    private int balls;
    private int strikes;
    private ResultTurn resultTurn;

    TurnScore() {}

    TurnScore(int balls, int strikes, ResultTurn resultTurn) {
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
}
