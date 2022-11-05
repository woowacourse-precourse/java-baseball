package baseball.condition.gameinput;

import baseball.condition.Condition;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class SmallerThanMaxSizeCond implements Condition {
    @Override
    public Boolean hasFulfilled(Integer guess) {
        return Integer.toString(guess).length() <= NUMBER_SIZE;
    }
}
