package baseball.game.condition.input;

import baseball.validation.condition.Condition;

public class AllDigitsNumberCond implements Condition {

    private static final Condition instance = new AllDigitsNumberCond();
    private final String NUMBER_FIND_REGEX = "[0-9]+";

    private AllDigitsNumberCond() {
    }

    @Override
    public Boolean isTrue(Integer guess) {
        return Integer.toString(guess).matches(NUMBER_FIND_REGEX);
    }

    public static Condition getInstance() {
        return instance;
    }
}
