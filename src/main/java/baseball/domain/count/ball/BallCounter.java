package baseball.domain.count.ball;

import baseball.domain.number.SingleNumber;

import java.util.List;

public class BallCounter {

    public BallResult checkBall(List<SingleNumber> randomNumbers, List<SingleNumber> inputNumbers) {
        int ballCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            ballCount += inputNumber.countBall(randomNumbers);
        }

        return new BallResult(ballCount);
    }
}
