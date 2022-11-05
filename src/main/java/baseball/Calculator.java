package baseball;

import static baseball.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int ball = INITIAL_COUNT;
    private int strike = INITIAL_COUNT;

    private List<Integer> dealerNumbers;
    private List<Integer> playerNumbers;
    private List<Integer> scores;

    public Calculator(List<Integer> dealerNumbers, List<Integer> playerNumbers) {
        this.dealerNumbers = dealerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getScores() {
        scores = new ArrayList<>();
        countBallAndStrike();
        scores.addAll(List.of(ball, strike));
        return scores;
    }

    public void countBallAndStrike() {
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i) == dealerNumbers.get(i)) {
                strike++;
                continue;
            }
            if (dealerNumbers.contains(playerNumbers.get(i))) {
                ball++;
            }
        }
    }
}
