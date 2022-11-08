package baseball.game.condition;

import baseball.error.GameError;
import baseball.validation.Condition;

import java.util.HashSet;
import java.util.Set;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class AllDigitsUniqueCond implements Condition {

    private static final Condition instance = new AllDigitsUniqueCond();
    private static final GameError error = GameError.NUMBER_DUPLICATED;

    public static Condition getInstance() {
        return instance;
    }

    private AllDigitsUniqueCond() {
    }

    @Override
    public Boolean isTrue(String guess) {
        Set<Character> numbers = new HashSet<>();

        for (int index = 0; index < NUMBER_SIZE; index++) {
            numbers.add(guess.charAt(index));
        }

        return numbers.size() == guess.length();
    }

    @Override
    public String getErrorMessage() {
        return error.getMessage();
    }
}
