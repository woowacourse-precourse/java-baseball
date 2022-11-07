package baseball.game.rule;

import baseball.game.enums.GuessTarget;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class StrikeCountRule implements Rule {

    private static final Rule instance = new StrikeCountRule();
    private static final GuessTarget guessTarget = GuessTarget.STRIKE;

    private StrikeCountRule() {
    }

    public static Rule getInstance() {
        return instance;
    }

    @Override
    public GuessTarget getResult() {
        return guessTarget;
    }

    @Override
    public Integer check(Integer answer, Integer guess) {
        String answerString = Integer.toString(answer);
        String guessString = Integer.toString(guess);
        int count = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (answerString.charAt(index) == guessString.charAt(index)) {
                count++;
            }
        }

        return count;
    }
}
