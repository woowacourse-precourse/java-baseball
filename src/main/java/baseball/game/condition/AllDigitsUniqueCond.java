package baseball.game.condition;

import baseball.validation.Condition;

import java.util.HashSet;
import java.util.Set;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class AllDigitsUniqueCond implements Condition {

    private static final Condition instance = new AllDigitsUniqueCond();

    public static Condition getInstance() {
        return instance;
    }

    private AllDigitsUniqueCond() {
    }

    @Override
    public Boolean isTrue(Integer guess) {
        String guessString = Integer.toString(guess);
        Set<Character> numbers = new HashSet<>();

        for (int index = 0; index < NUMBER_SIZE; index++) {
            numbers.add(guessString.charAt(index));
        }

        return numbers.size() == guessString.length();
    }
}
