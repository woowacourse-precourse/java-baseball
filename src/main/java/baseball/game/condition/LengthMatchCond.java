package baseball.game.condition;

import baseball.validation.Condition;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class LengthMatchCond implements Condition {

    private static final Condition instance = new LengthMatchCond();

    private LengthMatchCond() {
    }

    @Override
    public Boolean isTrue(Integer guess) {
        return Integer.toString(guess).length() == NUMBER_SIZE;
    }

    public static Condition getInstance() {
        return instance;
    }
}
