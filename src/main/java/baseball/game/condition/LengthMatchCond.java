package baseball.game.condition;

import baseball.validation.Condition;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class LengthMatchCond implements Condition {

    private static final Condition instance = new LengthMatchCond();

    public static Condition getInstance() {
        return instance;
    }

    private LengthMatchCond() {
    }

    @Override
    public Boolean isTrue(String guess) {
        return guess.length() == NUMBER_SIZE;
    }
}
