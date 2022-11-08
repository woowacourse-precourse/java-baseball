package baseball.game.condition;

import baseball.validation.Condition;

public class AllDigitsNumberCond implements Condition {

    private static final Condition instance = new AllDigitsNumberCond();
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
}
