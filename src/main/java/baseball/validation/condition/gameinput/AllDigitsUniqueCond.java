package baseball.condition.gameinput;

import baseball.condition.Condition;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class AllDigitsUniqueCond implements Condition {
    @Override
    public Boolean hasFulfilled(Integer guess) {
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
}
