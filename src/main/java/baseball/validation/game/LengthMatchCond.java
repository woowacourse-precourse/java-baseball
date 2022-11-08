package baseball.validation.game;

import baseball.error.GameError;
import baseball.validation.Condition;

import static baseball.interaction.GameUtil.NUMBER_SIZE;

public class LengthMatchCond implements Condition {

    private static final Condition instance = new LengthMatchCond();
    private static final GameError error = GameError.OVER_MAX_LENGTH;

    public static Condition getInstance() {
        return instance;
    }

    private LengthMatchCond() {
    }

    @Override
    public Boolean isTrue(String guess) {
        return guess.length() == NUMBER_SIZE;
    }

    @Override
    public String getErrorMessage() {
        return error.getMessage();
    }
}
