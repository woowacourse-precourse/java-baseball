package baseball.game.rule;


import baseball.game.enums.GuessTarget;

import static baseball.game.util.GameUtil.NUMBER_SIZE;

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
    public Integer check(Integer answer, Integer guess) {
        String answerString = Integer.toString(answer);
        String guessString = Integer.toString(guess);
        int count = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            Integer findIndex = findCharFromString(answerString, guessString.charAt(index));
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
