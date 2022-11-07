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
}
