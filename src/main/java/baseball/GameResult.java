package baseball;

import static baseball.BaseballGame.MAX_NUMBER_SIZE;

import java.util.List;

public class GameResult {

    public Integer strike;
    private Integer ball;

    public void compareNumbers(List<Integer> randomNumber, int[] userNumber) {
        this.strike = 0;
        this.ball = 0;

        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            countStrike(randomNumber.get(i).intValue(), userNumber[i]);
            countBall(randomNumber, userNumber, i);
        }
    }

    private void countStrike(int random, int user) {
        if (random == user) {
            this.strike++;
        }
    }

    private void countBall(List<Integer> random, int[] user, int x) {
        int randomValue = random.get(x).intValue();
        for (int i = 0; i < MAX_NUMBER_SIZE; i++) {
            if (i != x && randomValue == user[i]) {
                ball++;
            }
        }
    }
}
