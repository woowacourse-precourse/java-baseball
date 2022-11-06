package baseball.domain;

import static baseball.type.HintType.BALL_ZERO;
import static baseball.type.HintType.STRIKE_ZERO;
import static baseball.type.NumberType.NUMBER_SIZE;

import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    public Hint(List<Integer> userNumbers, List<Integer> computerNumbers) {
        this.strike = STRIKE_ZERO.getValue();
        this.ball = BALL_ZERO.getValue();

        countHint(userNumbers, computerNumbers);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    private void countHint(List<Integer> userNumbers, List<Integer> computerNumbers) {
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
