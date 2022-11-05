package baseball.domain.count.ball;

import baseball.domain.number.SingleNumber;

import java.util.List;

public class BallCounter {

    public int checkBall(List<SingleNumber> randomNumbers, List<SingleNumber> inputNumbers) {
        int ballCount = 0;
        for (SingleNumber inputNumber : inputNumbers) {
            ballCount += inputNumber.countBall(randomNumbers);
        }

        return ballCount;
    }
}
