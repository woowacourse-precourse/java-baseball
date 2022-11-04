package baseball.problemmaker;

import baseball.Numbers;
import baseball.dto.BallCount;

public class Computer implements ProblemMaker{

    Numbers numbers;

    public Computer(Numbers randomNumbers) {
        numbers = randomNumbers;
    }

    @Override
    public BallCount findBallCount(Numbers numbers) {
        return new BallCount(0, 0);
    }
}
