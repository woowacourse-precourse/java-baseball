package baseball;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private int strike = 0;
    private int ball = 0;

    private List<Integer> dealerNumbers;
    private List<Integer> playerNumbers;
    private List<Integer> scores;

    public Calculator(List<Integer> dealerNumbers, List<Integer> playerNumbers) {
        this.dealerNumbers = dealerNumbers;
        this.playerNumbers = playerNumbers;
    }

    public List<Integer> getScores() {
        scores = new ArrayList<>();
        updateScores();
        return scores;
    }

    public void updateScores() {
        scores.add(ball);
        scores.add(strike);
    }
}
