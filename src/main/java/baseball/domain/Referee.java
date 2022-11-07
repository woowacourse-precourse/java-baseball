package baseball.domain;

import static baseball.domain.Balls.BALLS_FORMAL_SIZE;

public class Referee {

    private Balls computerBalls;
    private final Hint hint;

    public Referee(Balls computerBalls) {
        this.computerBalls = computerBalls;
        this.hint = new Hint();
    }

    public Hint judgeScore(Balls userBalls) {
        hint.init();
        for (int i = 0; i < BALLS_FORMAL_SIZE; i++) {
            decideStrike(userBalls, i);
            decideBall(userBalls, i);
        }
        return this.hint;
    }

    private void decideStrike(Balls userBalls, int index) {
        if (computerBalls.isStrikePosition(userBalls,index)) {
            hint.increasePoint(Score.STRIKE);
        }
    }

    private void decideBall(Balls userBalls, int index) {
        if (computerBalls.isBallPosition(userBalls,index)) {
            hint.increasePoint(Score.BALL);
        }
    }

    public boolean isEnd() {
        return hint.isOut();
    }
}
