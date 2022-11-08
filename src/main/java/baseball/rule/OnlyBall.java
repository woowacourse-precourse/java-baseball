package baseball.rule;

import baseball.View;

import static baseball.Constants.NO_BALL;
import static baseball.Constants.NO_STRIKE;

public class OnlyBall implements BaseballRule {
    @Override
    public boolean check(int ball, int strike) {
        return (!(ball == NO_BALL) && (strike == NO_STRIKE));
    }

    @Override
    public void execute(int ball, int strike) {
        View.printBall(ball);
    }
}
