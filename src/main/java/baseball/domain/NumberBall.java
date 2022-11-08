package baseball.domain;

import baseball.util.GameExceptionMessage;
import baseball.util.input.NumberBallsInput;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberBall {
    private int number;
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;

    public NumberBall(int number) {
        validate(number);
        this.number = number;
    }
    private void validate(int number) {
       if(!supportsNumberRange(number)) {
           throw new IllegalArgumentException(GameExceptionMessage.ENTER_NUMBER_FROM_ONE_TO_NINE);
       }
    }
    private boolean supportsNumberRange(int number) {
        return number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    public static List<NumberBall> makeSystemNumberBalls() {
        List<NumberBall> numberBalls = new ArrayList<>();
        while (numberBalls.size() < NumberBallsInput.BALL_COUNT) {
            NumberBall ball = new NumberBall(Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER));
            if (!numberBalls.contains(ball)) {
                numberBalls.add(ball);
            }
        }
        return numberBalls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberBall that = (NumberBall) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
