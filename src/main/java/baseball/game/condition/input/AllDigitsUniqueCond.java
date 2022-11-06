package baseball.game.condition.input;

import baseball.validation.condition.Condition;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class AllDigitsUniqueCond implements Condition {

    private static final Condition instance = new AllDigitsUniqueCond();

    private AllDigitsUniqueCond() {
    }

    @Override
    public Boolean isTrue(Integer guess) {
        String s = Integer.toString(guess);

        for (Integer i = 0; i < NUMBER_SIZE - 1; i++) {
            for (Integer j = i + 1; j < NUMBER_SIZE; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static Condition getInstance() {
        return instance;
    }
}
