package baseball;

import java.util.List;

public class NumberCheck {

    private static final int INITIAL_VALUE = 0;

    private int strike;
    private int ball;

    public NumberCheck() {
        this.strike = INITIAL_VALUE;
        this.ball = INITIAL_VALUE;
    }

    public void checkLocationNumbers(UserNumber userNumbers, List<Integer> computerNumbers) {
        for (int i = INITIAL_VALUE; i < computerNumbers.size(); i++) {
            checkNumbers(userNumbers, computerNumbers, i);
        }
    }

    private void checkNumbers(UserNumber userNumbers, List<Integer> computerNumbers, int initialValue) {
        if (userNumbers.getUserNumbers().contains(computerNumbers.get(initialValue))) {
            if (userNumbers.getUserNumbers().get(initialValue).equals(computerNumbers.get(initialValue))) {
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
