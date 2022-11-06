package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NumberBall {
    private int number;

    public NumberBall(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static List<NumberBall> systemNumberBalls() {
        List<NumberBall> numberBalls = new ArrayList<>();
        while (numberBalls.size() < 3) {
            NumberBall ball = new NumberBall(Randoms.pickNumberInRange(1, 9));
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
