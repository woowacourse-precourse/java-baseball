package baseball.service;

import java.util.Map;

public class Calculator {

    private final Set set;
    private int ballResult;
    private int strikeResult;

    public Calculator(Set set) {
        this.set = set;
    }

    public Map<String, Integer> getResult() {
        return Map.of(
                ResultKeys.BALL.getKey(), ballResult,
                ResultKeys.STRIKE.getKey(), strikeResult
        );
    }

    public void calculate() {
        for (int i = 0; i < GameSetting.NUMBER_LENGTH.getAttribute(); i++) {
            calculateBall(i);
            calculateStrike(i);
        }
    }

    private void calculateBall(int index) {
        if (!set.computerAnswer.get(index).equals(set.userAnswer.get(index))
                && set.computerAnswer.contains(set.userAnswer.get(index))) {
            ballResult++;
        }
    }

    private void calculateStrike(int index) {
        if (set.computerAnswer.get(index).equals(set.userAnswer.get(index))) {
            strikeResult++;
        }
    }
}
