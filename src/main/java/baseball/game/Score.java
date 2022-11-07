package baseball.game;

import java.util.List;
import java.util.Objects;

import static baseball.game.Const.*;

public class Score {
    private final int strike;
    private final int ball;

    private Score(List<Integer> computerNumbers, List<Integer> userNumbers) {
        this.strike = calculateStrike(computerNumbers, userNumbers);
        this.ball = calculateBall(computerNumbers, userNumbers) - this.strike;
        printResult();
    }

    public static Score calculate(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return new Score(computerNumbers, userNumbers);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isWin() {
        return strike == GAME_LENGTH;
    }

    private int calculateStrike(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        for (int i = 0; i < GAME_LENGTH; i++) {
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int calculateBall(List<Integer> computerNumber, List<Integer> userNumbers) {
        int ball = 0;
        for (int i = 0; i < GAME_LENGTH; i++) {
            if (computerNumber.contains(userNumbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private void printResult() {
        if (strike > 0 && ball > 0) {
            System.out.printf(GAME_SCORE_STRIKE_BALL_MESSAGE, ball, strike);
            return;
        }
        if (strike > 0) {
            System.out.printf(GAME_SCORE_STRIKE_MESSAGE, strike);
            return;
        }
        if (ball > 0) {
            System.out.printf(GAME_SCORE_BALL_MESSAGE, ball);
            return;
        }
        System.out.println(GAME_SCORE_NOTHING_MESSAGE);
    }
}
