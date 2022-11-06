package baseball.domain.count.ball;

import baseball.domain.number.SingleNumber;
import baseball.domain.number.inputnumber.InputNumbers;

import java.util.List;

public class BallCounter {

    public int checkBall(List<SingleNumber> randomNumbers, InputNumbers inputNumbers) {
        return inputNumbers.countBall(randomNumbers);
    }
}
