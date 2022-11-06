package baseball;

import java.util.List;

public class NumberCheck {

    private static final int INITIAL_REPEAT_VALUE = 0;

    private int strike;
    private int ball;

    public NumberCheck(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    private void checkLocationNumbers(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int i = INITIAL_REPEAT_VALUE; i < userNumbers.size(); i++) {
            checkNumbers(userNumbers, computerNumbers);
        }
    }

    private void checkNumbers(List<Integer> userNumbers, List<Integer> computerNumbers) {
        if (userNumbers.contains(computerNumbers.get(INITIAL_REPEAT_VALUE))) {
            if (userNumbers.get(INITIAL_REPEAT_VALUE).equals(computerNumbers.get(INITIAL_REPEAT_VALUE))) {
                strike++;
            } else {
                ball++;
            }
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
