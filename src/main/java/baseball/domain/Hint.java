package baseball.domain;

import static baseball.type.NumberType.NUMBER_SIZE;

import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void countHint(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int index = 0; index < NUMBER_SIZE.getValue(); index++) {
            int userNumber = userNumbers.get(index);
            int computerNumber = computerNumbers.get(index);

            if (userNumber == computerNumber) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(userNumber)) {
                ball++;
            }
        }
    }
}
