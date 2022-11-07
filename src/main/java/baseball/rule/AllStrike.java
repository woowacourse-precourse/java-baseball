package baseball.rule;

import baseball.View;

import static baseball.BaseballConstants.*;

public class AllStrike implements BaseballRule {
    @Override
    public boolean check(int ball, int strike) {
        return ((ball == NO_BALL) && (strike == ALL_STRIKE));
    }

    @Override
    public void execute(int ball, int strike) {
        View.printStrike(strike);
        View.printCollect();
    }
}
