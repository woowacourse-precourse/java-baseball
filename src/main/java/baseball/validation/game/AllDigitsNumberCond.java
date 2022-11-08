package baseball.validation.game;

import baseball.error.GameError;
import baseball.validation.Condition;

public class AllDigitsNumberCond implements Condition {

    private static final Condition instance = new AllDigitsNumberCond();
    private static final GameError error = GameError.CONTAINS_NON_NUMBER;
    private final String NUMBER_FIND_REGEX = "[0-9]+";

    public static Condition getInstance() {
        return instance;
    }

    private AllDigitsNumberCond() {
    }

    @Override
    public Boolean isTrue(String guess) {
        return guess.matches(NUMBER_FIND_REGEX);
    }

    @Override
    public String getErrorMessage() {
        return error.getMessage();
    }

}
