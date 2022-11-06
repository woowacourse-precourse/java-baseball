package baseball.game.condition.input;

import baseball.validation.condition.Condition;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class SmallerThanMaxSizeCond implements Condition {

    private static final Condition instance = new SmallerThanMaxSizeCond();

    private SmallerThanMaxSizeCond() {
    }

    @Override
    public Boolean isTrue(Integer guess) {
        return Integer.toString(guess).length() <= NUMBER_SIZE;
    }

    public static Condition getInstance() {
        return instance;
    }
}
