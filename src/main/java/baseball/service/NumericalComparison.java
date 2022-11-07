package baseball.service;

import java.util.List;
import java.util.Map;

public class NumericalComparison {
    private int ball;
    private int strike;

    private static final int INITIALIZATION = 0;

    private NumericalComparison() {
    }

    private static class LazyHolder {
        private static final NumericalComparison INSTANCE = new NumericalComparison();
    }

    public static NumericalComparison getInstance() {
        return NumericalComparison.LazyHolder.INSTANCE;
    }

    public Map<String, Integer> compareList(List<Integer> computerNumbers, List<Integer> userNumbers) {
        resetCounts();
        for (int i = 0; i < 3; i++) {
            if (computerNumbers.get(i).equals(userNumbers.get(i)))
                strike++;
            else if (userNumbers.contains(computerNumbers.get(i)))
                ball++;
        }
        return Map.of("strike", strike, "ball", ball);
    }

    private void resetCounts() {
        strike = INITIALIZATION;
        ball = INITIALIZATION;
    }
}
