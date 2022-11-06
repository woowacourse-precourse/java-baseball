package baseball.domain;

import static baseball.type.NumberType.NUMBER_SIZE;

import java.util.List;
import java.util.Objects;

public class Hint {
    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void countHint(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int index = 0; index < NUMBER_SIZE; index++) {
            if (Objects.equals(userNumbers.get(index), computerNumbers.get(index))) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(userNumbers.get(index))) {
                ball++;
            }
        }
    }
}
