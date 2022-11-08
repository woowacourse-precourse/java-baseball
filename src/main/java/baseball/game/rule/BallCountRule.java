package baseball.game.rule;


import baseball.enums.game.GuessTarget;

import static baseball.interaction.GameUtil.NUMBER_SIZE;

public class BallCountRule implements Rule {

    private static final Rule instance = new BallCountRule();
    private static final GuessTarget guessTarget = GuessTarget.BALL;
    private static final Integer NOT_FOUND_INDEX = -1;

    private BallCountRule() {
    }

    public static Rule getInstance() {
        return instance;
    }

    @Override
    public GuessTarget getResult() {
        return guessTarget;
    }

    @Override
    public Integer check(String answer, String guess) {
        int count = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            Integer findIndex = findCharFromString(answer, guess.charAt(index));
            if (findIndex != NOT_FOUND_INDEX && index != findIndex) {
                count++;
            }
        }

        return count;
    }

    private Integer findCharFromString(String answerString, char targetChar) {
        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (answerString.charAt(index) == targetChar) {
                return index;
            }
        }

        return -1;
    }
}
