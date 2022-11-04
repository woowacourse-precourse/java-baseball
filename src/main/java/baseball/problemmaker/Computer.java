package baseball.problemmaker;

import baseball.Numbers;
import baseball.dto.BallCount;
import java.util.Objects;

public class Computer implements ProblemMaker {

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

    @Override
    public void printHintOfBallCount(BallCount ballCount) {
        StringBuilder ballCountBuilder = new StringBuilder();
        int strike = ballCount.getStrike();
        int ball = ballCount.getBall();

        if (ball != 0) {
            ballCountBuilder.append(ball).append("볼 ");
        }
        if (strike != 0) {
            ballCountBuilder.append(strike).append("스트라이크");
        }
        if (ballCountBuilder.length() == 0) {
            ballCountBuilder.append("낫싱");
        }

        System.out.println(ballCountBuilder);
    }

    @Override
    public boolean isFinishedCurrentGame(BallCount ballCount) {
        return false;
    }
}
