package baseball.problemmaker;

import baseball.Numbers;
import baseball.dto.BallCount;
import java.util.Objects;

public class Computer implements ProblemMaker{

    Numbers numbers;

    public Computer(Numbers randomNumbers) {
        numbers = randomNumbers;
    }

    @Override
    public BallCount findBallCount(Numbers numbers) {
        int strike = 0;
        int ball = 0;
        for (int numberIndex = 0; numberIndex < numbers.getNumbers().size(); numberIndex++) {
            Integer number = numbers.getNumbers().get(numberIndex);
            if (isStrike(number, numberIndex)) {
                strike++;
            }

            if (isBall(number, numberIndex)) {
                ball++;
            }
        }
        return new BallCount(strike, ball);
    }

    private boolean isBall(Integer number, int numberIndex) {
        if (!numbers.getNumbers().contains(number)) {
            return false;
        }
        return !Objects.equals(numbers.getNumbers().get(numberIndex), number);
    }

    private boolean isStrike(Integer number, int numberIndex) {
        return Objects.equals(numbers.getNumbers().get(numberIndex), number);
    }
}
