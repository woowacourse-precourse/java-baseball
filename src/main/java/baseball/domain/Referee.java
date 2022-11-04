package baseball.domain;

import static baseball.domain.Balls.BALLS_FORMAL_SIZE;

public class Referee {

    private Balls comBalls;
    private final Hint hint;

    public Referee(Balls comBalls) {
        this.comBalls = comBalls;
        this.hint = new Hint();
    }

    public Hint getHint(Balls userBalls) {
        hint.init();
        for (int i = 0; i < BALLS_FORMAL_SIZE; i++) {
            getStrike(userBalls, i);
            getBall(userBalls, i);
        }
        return this.hint;
    }

    private void getStrike(Balls userBalls, int index) {
        if (comBalls.isStrikePosition(userBalls,index)) {
            hint.increasePoint(Score.STRIKE);
        }
    }

    private void getBall(Balls userBalls, int index) {
        if (comBalls.isBallPosition(userBalls,index)) {
            hint.increasePoint(Score.BALL);
        }
    }

    public boolean isEnd() {
        return hint.isOut();
    }
}
