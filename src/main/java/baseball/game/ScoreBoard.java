package baseball.game;

import java.util.Arrays;
import java.util.List;

public class ScoreBoard {

    private int strike;
    private int ball;

    public void addStrike() {
        this.strike++;
    }

    public void addBall() {
        this.ball++;
    }

    public List<Integer> getScore() {
        return Arrays.asList(strike, ball);
    }

    public void calculate(List<Integer> targetNumbers, List<Integer> requestNumbers) {
        for (int number : requestNumbers) {

            if (targetNumbers.indexOf(number) == requestNumbers.indexOf(number)) {
                addStrike();
                continue;
            }

            if (targetNumbers.contains(number)) {
                addBall();
            }
        }

    }

}
