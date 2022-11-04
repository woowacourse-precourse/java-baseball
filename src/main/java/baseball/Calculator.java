package baseball;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int ball = 0;
    private int strike = 0;

    private List<Integer> dealerNumbers;
    private List<Integer> playerNumbers;
    private List<Integer> scores;

    public Calculator(List<Integer> playerNumbers, List<Integer> dealerNumbers) {
        this.playerNumbers = playerNumbers;
        this.dealerNumbers = dealerNumbers;
    }

    public List<Integer> getScores() {
        scores = new ArrayList<>();
        updateScores();
        return scores;
    }

    public void updateScores() {
        countBallAndStrike();
        scores.addAll(List.of(ball, strike));
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
