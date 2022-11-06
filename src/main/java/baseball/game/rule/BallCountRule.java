package baseball.game.rule;


import static baseball.game.util.GameUtil.NUMBER_SIZE;

public class BallCountRule implements Rule {
    @Override
    public Integer check(Integer answer, Integer guess) {
        String answerString = Integer.toString(answer);
        String guessString = Integer.toString(guess);
        int count = 0;

        for (int index = 0; index < NUMBER_SIZE; index++) {
            for (int iindex = 0; iindex < NUMBER_SIZE; iindex++) {
                if (index != iindex && answerString.charAt(index) == guessString.charAt(iindex)) {
                    count++;
                }
            }
        }

        return count;
    }
}
