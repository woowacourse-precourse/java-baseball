package baseball.rule;

import static baseball.gameconfig.GameConfiguration.NUMBER_SIZE;

public class StrikeCountRule implements Rule {
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
