package baseball.rule;

import baseball.View;

import static baseball.Constants.*;

public class OnlyStrike implements BaseballRule {
    @Override
    public boolean check(int ball, int strike) {
        return ((ball == NO_BALL) && !(strike == NO_STRIKE) && !(strike == ALL_STRIKE));
    }

    @Override
    public void execute(int ball, int strike) {
        View.printStrike(strike);
    }
}
